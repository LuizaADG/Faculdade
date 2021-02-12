import random
import socket
import sys


# Places a ship on the passed grid and returns the new grid
def place_ship(position, ship_length, grid):
    global server_grid, player_grid

    # Check position validity
    if len(position) != 3 or position[0] not in 'abcdefghij' or not 0 <= int(position[1]) <= 9 or position[2] not in 'hv':
        raise Exception('Invalid position')

    # Check if ship doesn't go off grid
    if (position[2] == 'h' and int(position[1]) > 10 - ship_length) or (position[2] == 'v' and ord(position[0]) > ord('j') - (ship_length-1)):
        raise Exception('The ship is too long to fit on this position')

    # Check if player is not trying to put two ships in overlapping positions
    if overwriting(position, ship_length, grid):
        raise Exception('This placement will cause ships to overlap')

    # Place ship
    if position[2] == 'h':
        for i in range(ship_length):
            coordinate = position[0] + str(int(position[1]) + i)
            grid[coordinate] = 'C' if ship_length == 5 else 'B' if ship_length == 4 else 'D' if ship_length == 3 else 'S'
    else:
        for i in range(ship_length):
            coordinate = chr(ord(position[0]) + i) + position[1]
            grid[coordinate] = 'C' if ship_length == 5 else 'B' if ship_length == 4 else 'D' if ship_length == 3 else 'S'

    return grid


# Asks player for the starting positions of their ships. Returns the populated grid
def get_player_placement(player_grid):
    instr = 'To place a ship, type its coordinate (e.g: a1) and orientation (h or v), all lowercase with no spaces' + \
            '\nShips placed horizontally will extend to the right, and vertically will extend down' + \
            '\nFor example: a carrier placed in \'d3h\' will occupy d3 to d7' + \
            '\n\nPlace your carrier (5 spaces): '

    # Place carrier
    conn.sendall(instr.encode())
    while True:
        try:
            position = conn.recv(1024)
            player_grid = place_ship(position.decode(), 5, player_grid)
            break
        except Exception as exception:
            conn.sendall((str(exception) + '\nPlace your carrier (5 spaces): ').encode())

    # Place battleship
    conn.sendall('Place your battleship (4 spaces): '.encode())
    while True:
        try:
            position = conn.recv(1024)
            player_grid = place_ship(position.decode(), 4, player_grid)
            break
        except Exception as exception:
            conn.sendall((str(exception) + '\nPlace your battleship (4 spaces): ').encode())

    # Place destroyer
    conn.sendall('Place your cruiser (3 spaces): '.encode())
    while True:
        try:
            position = conn.recv(1024)
            player_grid = place_ship(position.decode(), 3, player_grid)
            break
        except Exception as exception:
            conn.sendall((str(exception) + '\nPlace your cruiser (3 spaces): ').encode())

    # Place submarine
    conn.sendall('Place your submarine (2 spaces): '.encode())
    while True:
        try:
            position = conn.recv(1024)
            player_grid = place_ship(position.decode(), 2, player_grid)
            break
        except Exception as exception:
            conn.sendall((str(exception) + '\nPlace your submarine (2 spaces): ').encode())

    return player_grid


# Destroys whatever is in the passed position and returns the updated grid and if it was a hit or not
def shoot_position(position, grid):
    hit = grid[position] != 0 and grid[position] not in 'x_'
    grid[position] = 'x' if hit else '_'
    return grid, hit


# Checks if a ship being place in this position will not override another already placed ship
def overwriting(position, ship_length, grid):

    if position[2] == 'h':
        for i in range(ship_length):
            coordinate = position[0] + str(int(position[1]) + i)
            if grid[coordinate] != 0:
                return True
    else:
        for i in range(ship_length):
            coordinate = chr(ord(position[0]) + i) + position[1]
            if grid[coordinate] != 0:
                return True

    return False


# Places server ships and returns the new grid
def get_server_placement(server_grid):
    # Place carrier
    while True:
        position = random.choice('hv')
        position = (random.choice('012345') if position == 'h' else random.choice('0123456789')) + position
        position = (random.choice('abcdefghij') if position == 'h' else random.choice('abcdef')) + position
        if not overwriting(position, 5, server_grid):
            break
    server_grid = place_ship(position, 5, server_grid)

    # Place battleship
    while True:
        position = random.choice('hv')
        position = (random.choice('0123456') if position == 'h' else random.choice('0123456789')) + position
        position = (random.choice('abcdefghij') if position == 'h' else random.choice('abcdefg')) + position
        if not overwriting(position, 4, server_grid):
            break
    server_grid = place_ship(position, 4, server_grid)

    # Place destroyer
    while True:
        position = random.choice('hv')
        position = (random.choice('01234567') if position == 'h' else random.choice('0123456789')) + position
        position = (random.choice('abcdefghij') if position == 'h' else random.choice('abcdefgh')) + position
        if not overwriting(position, 3, server_grid):
            break
    server_grid = place_ship(position, 3, server_grid)

    # Place submarine
    while True:
        position = random.choice('hv')
        position = (random.choice('012345678') if position == 'h' else random.choice('0123456789')) + position
        position = (random.choice('abcdefghij') if position == 'h' else random.choice('abcdefgi')) + position
        if not overwriting(position, 2, server_grid):
            break

    server_grid = place_ship(position, 2, server_grid)

    return server_grid


# Prints player grid and known info on server's grid
def print_grids(player_grid, server_grid):
    # Print player grid
    data = 'Your current grid: \n'
    for letter in 'abcdefghij':
        for number in '012345679':
            data = data + player_grid[letter + number] + ' ' if player_grid[letter + number] != 0 else data + '_ '
        data = data + '\n'

    # Print known info of server grid
    data = data + '\nMy grid: \n'
    for letter in 'abcdefghij':
        for number in '012345679':
            data = data + server_grid[letter + number] + ' ' if str(server_grid[letter + number]) in 'x_' else data + '? '
        data = data + '\n'

    return data


# Checks if positions surrounding the given position have already been shot and returns them if not
def viable_adjacent_shots(position, player_grid):
    viable_adjacent_shots = []

    # Look up
    if position[0] != 'a' and str(player_grid[chr(ord(position[0]) - 1) + position[1]]) not in 'x_':
        viable_adjacent_shots.append(chr(ord(position[0]) - 1) + position[1])

    # Look down
    if position[0] != 'j' and str(player_grid[chr(ord(position[0]) + 1) + position[1]]) not in 'x_':
        viable_adjacent_shots.append(chr(ord(position[0]) + 1) + position[1])

        # Look left
    if position[1] != '0' and str(player_grid[position[0] + str(int(position[1]) - 1)]) not in 'x_':
        viable_adjacent_shots.append(position[0] + str(int(position[1]) - 1))

        # Look right
    if position[1] != '9' and str(player_grid[position[0] + str(int(position[1]) + 1)]) not in 'x_':
        viable_adjacent_shots.append(position[0] + str(int(position[1]) + 1))

    return viable_adjacent_shots


player_grid = {'a0': 0, 'a1': 0, 'a2': 0, 'a3': 0, 'a4': 0, 'a5': 0, 'a6': 0, 'a7': 0, 'a8': 0, 'a9': 0,
               'b0': 0, 'b1': 0, 'b2': 0, 'b3': 0, 'b4': 0, 'b5': 0, 'b6': 0, 'b7': 0, 'b8': 0, 'b9': 0,
               'c0': 0, 'c1': 0, 'c2': 0, 'c3': 0, 'c4': 0, 'c5': 0, 'c6': 0, 'c7': 0, 'c8': 0, 'c9': 0,
               'd0': 0, 'd1': 0, 'd2': 0, 'd3': 0, 'd4': 0, 'd5': 0, 'd6': 0, 'd7': 0, 'd8': 0, 'd9': 0,
               'e0': 0, 'e1': 0, 'e2': 0, 'e3': 0, 'e4': 0, 'e5': 0, 'e6': 0, 'e7': 0, 'e8': 0, 'e9': 0,
               'f0': 0, 'f1': 0, 'f2': 0, 'f3': 0, 'f4': 0, 'f5': 0, 'f6': 0, 'f7': 0, 'f8': 0, 'f9': 0,
               'g0': 0, 'g1': 0, 'g2': 0, 'g3': 0, 'g4': 0, 'g5': 0, 'g6': 0, 'g7': 0, 'g8': 0, 'g9': 0,
               'h0': 0, 'h1': 0, 'h2': 0, 'h3': 0, 'h4': 0, 'h5': 0, 'h6': 0, 'h7': 0, 'h8': 0, 'h9': 0,
               'i0': 0, 'i1': 0, 'i2': 0, 'i3': 0, 'i4': 0, 'i5': 0, 'i6': 0, 'i7': 0, 'i8': 0, 'i9': 0,
               'j0': 0, 'j1': 0, 'j2': 0, 'j3': 0, 'j4': 0, 'j5': 0, 'j6': 0, 'j7': 0, 'j8': 0, 'j9': 0}

server_grid = {'a0': 0, 'a1': 0, 'a2': 0, 'a3': 0, 'a4': 0, 'a5': 0, 'a6': 0, 'a7': 0, 'a8': 0, 'a9': 0,
               'b0': 0, 'b1': 0, 'b2': 0, 'b3': 0, 'b4': 0, 'b5': 0, 'b6': 0, 'b7': 0, 'b8': 0, 'b9': 0,
               'c0': 0, 'c1': 0, 'c2': 0, 'c3': 0, 'c4': 0, 'c5': 0, 'c6': 0, 'c7': 0, 'c8': 0, 'c9': 0,
               'd0': 0, 'd1': 0, 'd2': 0, 'd3': 0, 'd4': 0, 'd5': 0, 'd6': 0, 'd7': 0, 'd8': 0, 'd9': 0,
               'e0': 0, 'e1': 0, 'e2': 0, 'e3': 0, 'e4': 0, 'e5': 0, 'e6': 0, 'e7': 0, 'e8': 0, 'e9': 0,
               'f0': 0, 'f1': 0, 'f2': 0, 'f3': 0, 'f4': 0, 'f5': 0, 'f6': 0, 'f7': 0, 'f8': 0, 'f9': 0,
               'g0': 0, 'g1': 0, 'g2': 0, 'g3': 0, 'g4': 0, 'g5': 0, 'g6': 0, 'g7': 0, 'g8': 0, 'g9': 0,
               'h0': 0, 'h1': 0, 'h2': 0, 'h3': 0, 'h4': 0, 'h5': 0, 'h6': 0, 'h7': 0, 'h8': 0, 'h9': 0,
               'i0': 0, 'i1': 0, 'i2': 0, 'i3': 0, 'i4': 0, 'i5': 0, 'i6': 0, 'i7': 0, 'i8': 0, 'i9': 0,
               'j0': 0, 'j1': 0, 'j2': 0, 'j3': 0, 'j4': 0, 'j5': 0, 'j6': 0, 'j7': 0, 'j8': 0, 'j9': 0}


host = '127.0.0.1'
port = None
try:
    port = int(sys.argv[1])
except:
    print('Must pass the port as an argument e.g: python battleship.py 65350')
    exit()

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    print('Waiting for client to connect...')
    s.bind((host, port))
    s.listen()
    conn, addr = s.accept()
    print('Game started')

    player_grid = get_player_placement(player_grid)
    server_grid = get_server_placement(server_grid)
    probable_hits = []

    answer = ''
    while any([i for i in 'CBDS' if i in server_grid.values()]) and any([i for i in 'CBDS' if i in player_grid.values()]):
        # Player turn
        conn.sendall((answer + '\n\n---Your turn---\nShoot a position:').encode())
        position = conn.recv(1024).decode()  # TODO: handle exceptions
        if position == 'p':
            answer = print_grids(player_grid, server_grid)
            continue
        server_grid, hit = shoot_position(position, server_grid)
        answer = 'Hit on ' + position if hit else 'Miss'

        # Server turn
        answer = answer + '\n\n---My turn---'
        position = probable_hits.pop() if probable_hits else random.choice('abcdefghij') + random.choice('0123456789')
        answer = answer + '\nI\'ll shoot ' + position
        player_grid, hit = shoot_position(position, player_grid)
        answer = answer + '\nHit on ' + position if hit else answer + '\nMiss'

        if hit:
            probable_hits = probable_hits + viable_adjacent_shots(position, player_grid)

    conn.sendall('\nYou win'.encode()) if any('CBDS') in player_grid.values() else conn.sendall('\nYou lose'.encode())
    s.close()


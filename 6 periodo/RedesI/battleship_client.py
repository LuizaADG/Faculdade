import socket
import sys

host = '127.0.0.1'
port = None
try:
    port = int(sys.argv[1])
except:
    print('Must pass the port as an argument e.g: python battleship.py 65350')
    exit()

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((host, port))
    while True:
        data = s.recv(1024).decode()
        print(data + '\n')
        if data == '\nYou lose' or data == '\nYou win':
            break
        else:
            data = input()
            s.sendall(data.encode())
    s.close()

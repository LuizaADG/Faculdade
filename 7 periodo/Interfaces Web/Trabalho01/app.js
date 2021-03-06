const API_KEY=`58a68be0e8094b83bb58280905faf730`
var i = 0;

function populares() {
	const query_string = "https://api.themoviedb.org/3/movie/popular?api_key="+API_KEY+"&language=pt-BR";
	const container = document.getElementById("aqui");
	container.innerHtml = "";
	if (container == null) return;
	var request = new XMLHttpRequest();
	request.open('GET', query_string, true);
	request.onload = function () {
		var resposta = JSON.parse(this.response);
		if (request.status >= 200 && request.status < 400) {
			var movie;
			for (var j = i + 2; i<j; i++) {
				movie = resposta.results[i];
				const card = document.createElement('div');
				card.setAttribute('class', 'col-12 col-sm-6 col-md-3 col-lg-3');
				const imagem = document.createElement('img');
                imagem.setAttribute('src', "https://image.tmdb.org/t/p/w220_and_h330_face"+movie.poster_path);
                const h1 = document.createElement('p');
                var titulo = movie.original_title;
                h1.textContent = `Titulo: ${titulo}`;
                h1.setAttribute('class', 'col-12 col-sm-6 col-md-3 col-lg-3')
				const p = document.createElement('p');
				var descricao = movie.overview.substring(0, 300);
				p.textContent = `Overview: ${descricao}`;
				container.appendChild(card);
				card.appendChild(imagem);
				card.appendChild(h1);
				card.appendChild(p);
			};
		} else {
			console.log('error');
		}
	}
	request.send();
}
populares();

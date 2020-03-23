const proxy = 'https://cors-anywhere.herokuapp.com/'
const api = `${proxy}https://is.gd/create.php`
	
const inputUrl = document.querySelector('#url')
const shortUrlHidden = document.querySelector('#shorturl_hidden')
	

   	

const getShortUrl = async () => {
	
	event.preventDefault();
	
	if (inputUrl.value.length <= 0) {
        alert('Preencha o campo com a url')
        return false
    }
	
    const span = document.querySelector('#shortUrl')
    span.innerHTML = 'carregando...'

    const { data: shortUrl } = await axios.get(`${api}?format=simple&url=${inputUrl.value}`)

    span.innerHTML = shortUrl
    shortUrlHidden.value = shortUrl

}

document.querySelector("#btnSubmit").addEventListener('click', (e) => {

    const inputUrl = document.querySelector('#url')
    
 
    
    if (shortUrlHidden.value.length <= 0) {
        alert('Gere a URL')
        return false
    }

    document.querySelector("#formUrl").submit()

})
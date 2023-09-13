document.getElementById('forward').addEventListener('click', (e) => {
    fetch('http://192.168.0.129:8080/forward', {method: 'POST'})
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('left').addEventListener('click', (e) => {
    fetch('http://192.168.0.129:8080/left', {method: 'POST'})
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('right').addEventListener('click', (e) => {
    fetch('http://192.168.0.129:8080/right', {method: 'POST'})
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('backwards').addEventListener('click', (e) => {
    fetch('http://192.168.0.129:8080/backwards', {method: 'POST'})
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('stop').addEventListener('click', (e) => {
    fetch('http://192.168.0.129:8080/stop', {method: 'POST'})
    .then(response => response.json())
    .then(response => console.log(response))
});
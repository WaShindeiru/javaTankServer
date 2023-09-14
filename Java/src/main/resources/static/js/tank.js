const url = 'http://192.168.0.167:80/update';
let pwmValue = 100;

const data = {
    forward: {
        direction: 'forward',
        pwm: pwmValue
    },

    left: {
        direction: 'left',
        pwm: pwmValue
    },

    right: {
        direction: 'right',
        pwm: pwmValue
    },

    backwards: {
        direction: 'backwards',
        pwm: pwmValue
    },

    stop: {
        direction: 'stop',
        pwm: pwmValue
    }
}

function getOptions(value) {
    return {
        method: 'POST',
        body: JSON.stringify(data[value]),
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    }
}

document.getElementById('forward').addEventListener('click', (e) => {
    fetch(url, getOptions('forward'))
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('left').addEventListener('click', (e) => {
    fetch(url, getOptions('left'))
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('right').addEventListener('click', (e) => {
    fetch(url, getOptions('right'))
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('backwards').addEventListener('click', (e) => {
    fetch(url, getOptions('backwards'))
    .then(response => response.json())
    .then(response => console.log(response))
});

document.getElementById('stop').addEventListener('click', (e) => {
    fetch(url, getOptions('stop'))
    .then(response => response.json())
    .then(response => console.log(response))
});
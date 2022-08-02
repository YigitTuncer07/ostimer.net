let seconds = 0;
let tens = 0;
let minutes = 0;
let pressed = false;
let interval;

document.addEventListener('keyup', event => {
    if (event.code === 'Space'){
        if (!pressed){     
            reset();       
            interval = setInterval(startTime, 10);
            pressed = true;
        } else if (pressed){
            clearInterval(interval);
            pressed = false;
        }
        
    }
});

function startTime(){
    tens++;
    if (tens == 60){
        document.getElementById("tens").textContent = "00";
        tens = 0;
        seconds++;
        if (seconds == 60){
            document.getElementById("seconds").textContent = "00";
            seconds =0;
            minutes++;
            document.getElementById("minutes").textContent = minutes;

        } else {
            document.getElementById("seconds").textContent = seconds;
        }

    } else {
        document.getElementById("tens").textContent = tens;
    }    
    
}

function reset(){
    tens = 0;
    seconds = 0;
    minutes = 0;
    document.getElementById("tens").textContent = "00";
    document.getElementById("seconds").textContent = "00";
    document.getElementById("minutes").textContent = "00";


}
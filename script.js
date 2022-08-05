let seconds1 = 0;
let seconds2 = 0;
let tens1 = 0;
let tens2 = 0;
let minutes1 = 0;
let minutes2 = 0;
let pressed = false;
let interval;
let interval1;
let seconds01 = 1;
let seconds02 = 5;
let tens01 = 0;
let tens02 = 0;

document.addEventListener('keypress', event => {
    if (event.code === 'Space') {

        if (!pressed) {

            interval1 = setInterval(startSubTimer, 10);
            document.addEventListener('keyup', event => {

                reset();

                document.getElementById("subTimer").style.display = "none";

                interval = setInterval(startTime, 10);
                pressed = true;

            })

        } else {

            document.getElementById("subTimer").style.display = "block";


            clearInterval(interval);
            pressed = false;
        }




    }
});

function startTime() {
    tens2++;
    if (tens2 == 10) {
        tens2 = 0;
        document.getElementById("tens2").textContent = tens2;


        tens1++;
        if (tens1 == 10) {
            tens1 = 0;
            document.getElementById("tens1").textContent = tens1;


            seconds2++;
            if (seconds2 == 10) {
                seconds2 = 0;
                document.getElementById("seconds2").textContent = seconds2;


                seconds1++;
                if (seconds1 == 6) {
                    seconds1 = 0;
                    document.getElementById("seconds1").textContent = seconds1;


                    minutes2++;
                    if (minutes2 == 10) {
                        minutes2 = 0;
                        document.getElementById("minutes2").textContent = minutes2;


                        minutes1++;
                        if (minutes1 == 6) {
                            minutes1 = 0;
                            document.getElementById("minutes1").textContent = minutes1;

                        } else {
                            document.getElementById("minutes1").textContent = minutes1;

                        }

                    } else {
                        document.getElementById("minutes2").textContent = minutes2;
                    }

                } else {
                    document.getElementById("seconds1").textContent = seconds1;

                }

            } else {
                document.getElementById("seconds2").textContent = seconds2;
            }

        } else {
            document.getElementById("tens1").textContent = tens1;
        }

    } else {
        document.getElementById("tens2").textContent = tens2;
    }


}

function reset() {
    tens2 = 0;
    tens1 = 0;
    seconds2 = 0;
    seconds1 = 0;
    minutes2 = 0;
    minutes1 = 0;

    document.getElementById("tens1").textContent = "0";
    document.getElementById("tens2").textContent = "0";
    document.getElementById("seconds1").textContent = "0";
    document.getElementById("seconds2").textContent = "0";
    document.getElementById("minutes1").textContent = "0";
    document.getElementById("minutes2").textContent = "0";
}

function startSubTimer() {
    if (tens02 == 0) {
        tens02 = 9;
        document.getElementById("tens02").textContent = tens02;

    } else {
        tens02--;
    }

}
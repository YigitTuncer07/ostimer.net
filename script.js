let seconds1 = 0;
let seconds2 = 0;
let tens1 = 0;
let tens2 = 0;
let minutes1 = 0;
let minutes2 = 0;
let seconds01 = 1;
let seconds02 = 5;
let tens01 = 0;
let tens02 = 0;
let state = 0;
let interval;
let interval1;



function toggleSettings() {
    alert("blabla");

}

document.addEventListener('keyup', event => {

    if (event.code == 'Space') {

        switch (state) {

            case 0:
                reset();
                document.getElementById("subTimer").style.display = "block";
                interval1 = setInterval(startSubTime, 10);
                state = 1;
                break;

            case 1:
                resetSubTimer();
                document.getElementById("subTimer").style.display = "none";
                clearInterval(interval1);
                interval = setInterval(startTime, 10);
                state = 2;
                break;

            case 2:
                clearInterval(interval);
                state = 0;

                break;
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

function startSubTime() {

    if (tens02 == 0) {
        tens02 = 9;
        document.getElementById("tens02").textContent = tens02;


        if (tens01 == 0) {
            tens01 = 9;
            document.getElementById("tens01").textContent = tens01;

            if (seconds02 == 0) {
                seconds02 = 9;
                document.getElementById("seconds02").textContent = seconds02;

                if (seconds01 == 0) {
                    document.getElementById("subTimer").style.display = "none";
                    document.body.style.backgroundColor = "red";
                    state = 0;
                    clearInterval(interval1);
                    resetSubTimer();
                }

                seconds01--;
                document.getElementById("seconds01").textContent = seconds01;


            } else {
                seconds02--;
                document.getElementById("seconds02").textContent = seconds02;
            }
        } else {
            tens01--;
            document.getElementById("tens01").textContent = tens01;
        }
    } else {
        tens02--;
        document.getElementById("tens02").textContent = tens02;

    }
}

function reset() {
    tens2 = 0;
    tens1 = 0;
    seconds2 = 0;
    seconds1 = 0;
    minutes2 = 0;
    minutes1 = 0;

    document.body.style.backgroundColor = "#39CCCC";

    document.getElementById("tens1").textContent = "0";
    document.getElementById("tens2").textContent = "0";
    document.getElementById("seconds1").textContent = "0";
    document.getElementById("seconds2").textContent = "0";
    document.getElementById("minutes1").textContent = "0";
    document.getElementById("minutes2").textContent = "0";
}

function resetSubTimer() {
    seconds01 = 1;
    seconds02 = 5;
    tens01 = 0;
    tens02 = 0;

    document.getElementById("tens01").textContent = "0";
    document.getElementById("tens02").textContent = "0";
    document.getElementById("seconds01").textContent = "1";
    document.getElementById("seconds02").textContent = "5";
}
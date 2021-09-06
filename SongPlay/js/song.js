let audio = new Audio("sounds/oingoboingo.mp3");
let blnPlay = false;
let timer;


function play() {

    if (blnPlay == false) {
        audio.play();
        timer = setInterval(changeBackground, 2000);
    } else {
        audio.pause();
        clearInterval(timer);
    }

    blnPlay = !blnPlay;

}

function changeBackground() {
    let bk = document.body;
    let img = document.querySelector(".imgPlay");
    let songTitle = document.querySelector(".songTitle");
    let lyrics= document.querySelector(".lyrics");
    let text= document.querySelector(".text");
    let randomColor = Math.floor(Math.random() * 6) + 1;

    switch (randomColor) {
        case 1:
            bk.style.background = 'red';
            img.style.borderColor = 'blue';
            songTitle.style.color = 'blue';
            lyrics.style.color = 'white';
            text.style.color= 'white';
            break;
        case 2:
            bk.style.background = 'orange';
            img.style.borderColor = 'red';
            songTitle.style.color = 'red';
            break;
        case 3:
            bk.style.background = 'black';
            img.style.borderColor = 'green';
            songTitle.style.color = 'green';
            lyrics.style.color = 'white';
            text.style.color = 'white';
            break;

        case 4:
            bk.style.background = 'orchid';
            img.style.borderColor = 'yellow';
            songTitle.style.color = 'yellow';
            break;

        case 5: 
          bk.style.background = 'blue';
            img.style.borderColor = 'crimson';
            songTitle.style.color = 'crimson';
            lyrics.style.color = 'white';
            text.style.color = 'white';  
            text.font.weight= 'bolder'
            break;

        case 6: 
        bk.style.background = 'brown';
            img.style.borderColor = 'green';
            songTitle.style.color = 'green';
        
            default:
            bk.style.background = 'white';
            img.style.borderColor = 'purple';
            songTitle.style.color = 'purple';
            lyrics.style.color = 'black';
            text.style.color = 'black';
            text.font.weight= 'bolder'
            break;
    }

    

}
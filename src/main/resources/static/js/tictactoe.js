function OnClickMode1() {
    document.getElementById('player2name').style.display='none';
}

function OnClickMode2() {
    document.getElementById('player2name').style.display='block';
}

function TogglePlayersTurn() {
    var currPlayer = $('#whose-turn-is-it').text();
    console.log(currPlayer);
    if (currPlayer == $('#p1').text()) {
        $('#whose-turn-is-it').html($('#p2').text());
        document.getElementById('p1-info').style.color = 'rgb(0, 0, 0)';
        document.getElementById('p2-info').style.color = 'rgb(184, 84, 80)';
    }
    else {
        $('#whose-turn-is-it').html($('#p1').text());
        document.getElementById('p1-info').style.color = 'rgb(184, 84, 80)';
        document.getElementById('p2-info').style.color = 'rgb(0, 0, 0)';
    }
    console.log('player 1: ' + $('#p1').text());
    console.log('player 2: ' + $('#p2').text());
}

function MakeMove(elem) {
    var currPlayer = $('#whose-turn-is-it').text();
    console.log('players turn: ' + currPlayer);
    //var data = $("#game-table").v();
    $.ajax({
        type: "POST",
        url: "/tictactoe",
        dataType: "html",
        data: { player: currPlayer, cell: elem.id },
        success: function(result) {
            $("#game-table").replaceWith($(result).filter('#game-table'));
            // TODO: currPlayer is now the other player (those-turn-is-it)
            var message = $(result).filter('#hidden-message').text();

            if (message == currPlayer) {
                console.log("PLAYER WON");
                $('#game-results').replaceWith($(result).filter('#game-results'));
                $('#game-results').addClass("showing");
                document.getElementById('game-results').style.display='block';
                $('#game-result-message').html(message + ' is the winner!');
            }
            else if (message == "It's a tie!") {
                console.log("TIE");
                document.getElementById('game-results').style.display='block';
                $('#game-result-message').html(message);
            }
            else if (message == "Illegal move") {
                console.log("ILLEGAL");
            }
            else {
                TogglePlayersTurn();
            }
        },
        error: function(result) {
            console.log("error:");
            console.log(result);
            $("#game-table").html("");
        }
    });
}

// function PlayAgain() {
//     $.ajax({
//         type: "POST",
//         url: "/tictactoe",
//         dataType: "html",
//         data: { player: currPlayer, cell: elem.id },
//         success: function(result) {
            
//         },
//         error: function(result) {
//             console.log(result);
//         }
//     });
// }

/* $.ajax({
        type: "POST",
        url: "/tictactoe",
       
        success: function(result) {
            console.log(result);
            $("#game-table").replaceWith($(result).find("#game-table"));
            // TODO: currPlayer is now the other player (those-turn-is-it)
        }
    });*/
/**** front.html ****/
/* Human vs Computer mode chosen */
function OnClickMode1() {
    var player2 = document.getElementById('player2name');
    player2.value = 'Computer';
    document.getElementById('player2name').readOnly = true;
    $('#button-mode1').addClass('chosen');
    $('#button-mode2').removeClass('chosen');
    var mode = document.getElementById('mode');
    mode.value = 1;
}

/* Human vs Human mode chosen */
function OnClickMode2() {
    var player2 = document.getElementById('player2name');
    player2.value = '';
    document.getElementById('player2name').readOnly = false;
    $('#button-mode2').addClass('chosen');
    $('#button-mode1').removeClass('chosen');
    var mode = document.getElementById('mode');
    mode.value = 2;
}

/**** tictactoe.html ****/

/* Toggle whose turn it is next */
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
    if($('#whose-turn-is-it').text() == "Computer" )
     {
        $('#0').click();
     }

   
}

function LetComputerClick()
{
     if($('#whose-turn-is-it').html($('#p2').text()) == "Computer")
     {
        $('#0').click();
     }

}

/* Ajax functionality to deal with the player's input */
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



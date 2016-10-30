function OnClickMode1() {
    document.getElementById('player2name').style.display='none';
}

function OnClickMode2() {
    document.getElementById('player2name').style.display='block';
}

function TogglePlayersTurn() {
    var currPlayer = $('#whose-turn-is-it').text();
    if (currPlayer == $('#p1').text()) {
        $('#whose-turn-is-it').html($('#p2').text());
    }
    else {
        $('#whose-turn-is-it').html($('#p1').text());
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
                $('#game-results').show();
                $('#game-result-message').html(message);
            }
            else if (message == "It's a tie!") {
                console.log("TIE");
            }
            else if (message == "Illegal move") {
                console.log("ILLEGAL");
            }
            else {
                TogglePlayersTurn();
            }
        },
        error: function(result) {
            console.log(result)
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


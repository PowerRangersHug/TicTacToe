function OnClickMode1() {
    document.getElementById('player2name').style.display='none';
}

function OnClickMode2() {
    document.getElementById('player2name').style.display='block';
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
            console.log(result);
            console.log($(result).filter('#game-table'));
            $("#game-table").replaceWith($(result).filter('#game-table'));
            // TODO: currPlayer is now the other player (those-turn-is-it)
        },
        error: function(result) {
            console.log(result)
            $("#game-table").html("");
        }
    });
}
/* $.ajax({
        type: "POST",
        url: "/tictactoe",
       
        success: function(result) {
            console.log(result);
            $("#game-table").replaceWith($(result).find("#game-table"));
            // TODO: currPlayer is now the other player (those-turn-is-it)
        }
    });*/
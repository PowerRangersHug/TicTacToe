function OnClickMode1() {
    document.getElementById('player2name').style.display='none';
}

function OnClickMode2() {
    document.getElementById('player2name').style.display='block';
}

function MakeMove(elem) {
    var currPlayer = $('#whose-turn-is-it').text();
    // console.log('players turn: ' + player);

    $.ajax({
        type: "POST",
        url: "/tictactoe",
        data: { player: currPlayer, cell: elem.id, gameInfoViewModel : $('#the-view-model').val() },
        success: function(result) {
            console.log(result);
            $("#game-table").replaceWith($(result).find("#game-table"));
            // TODO: currPlayer is now the other player (those-turn-is-it)
        }
    });
}

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
        data: {player: currPlayer, cell:elem.id, gameInfoViewModel: $('#the-view-model').val()},
        success: function(result) {
            console.log(result);
            console.log($(result).filter('#game-table'));
            $("#game-table").replaceWith($(result).filter('#game-table'));

            /*var table = "";
            for(var i = 0; i < result.lengt; i++)
            {
                if(i == 0 || i == 3 || i == 6)
                {
                    table += "<tr>";
                }
                table += "<td id=\"" + i + "\" onclick=\"MakeMove(this)\" th:text=\"${" + result[i].symbol + "]}\"></td>";
                if(i == 2 || i == 5 || i == 8)
                {
                    table += "<\tr>";
                }
            }
            $("#game-table").html(table);*/

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
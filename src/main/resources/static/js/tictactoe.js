function OnClickMode1() {
    document.getElementById('player2name').style.display='none';
}

function OnClickMode2() {
    document.getElementById('player2name').style.display='block';
}

function MakeMove() {
    console.log('players turn: ');
    var data = $("#game-table").val();
    

    $.ajax({
        type: "POST",
        url: "/tictactoe",
        dataType: "json",
        data: JSON.stringify(data),
        success: function(data) {
            console.log(data);
            $("#game-table").html("");
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
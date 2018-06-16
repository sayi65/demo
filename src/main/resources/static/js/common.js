$(function(){
    $('#submit').click(function(e){
        e.preventDefault();

        var group = $('#group').val();
        var groupId = $('#groupId').val();

        if(group && groupId
                && !isNaN(groupId)
                && !isNaN(group)){
        var data = {
            group : $('#group').val(),
            id : $('#groupId').val()
        };

        $.ajax({
            type:'POST',
            url:'/postData',
            cache:false,
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json'
            })
            .done(function(response, textStatus, jqXHR){
                console.log(response);
                createTable(response);
            })
            .fail(function(jqXHR, textStatus, errorThrown){
                console.log(jqXHR);
            });
        }
    });

    function createTable(response){
        console.log(response.count);
        $('#table').empty();

        $('#table').append('<tr><td><strong>Group</strong></td><td><strong>Id</strong></td></tr>')

        if(Object.keys(response).length > 0){
           Object.keys(response).forEach(function (v, i){

                for(var i=0;i<response[v].length; i++){
                    if(i == 0){
                        $('#table').append('<tr><td rowspan="' + response[v].length +'">'+ v + '</td><td>' + response[v][i] + '</td></tr>');
                     } else {
                        $('#table').append('<tr><td style="display:none;">'+ v + '</td><td>' + response[v][i] + '</td></tr>');
                     }
                }
           });
        }
    }
});
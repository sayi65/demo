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
            type:'post',
            url:'/postData',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(data){

            },
            error: function(){
                alert("Server Error. Pleasy try again later.");
            },
            complete: function(){

            }
        });
        }
    });
});
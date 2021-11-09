function reportByDates(){
    $("#infoDate").removeAttr("style");
    $("#ByStatus").attr("style", "display: none");
    $("#ByClient").attr("style", "display: none");
    let ini = $("#startDate").val();
    let dev = $("#devolutionDate").val();
    $.ajax({
        dataType: 'json',
        url: "http://158.101.116.78:8080/api/Reservation/report-dates/" + ini + "/" + dev,
        type: "GET",
        success: function(response){
            var misItems = response;
            for (let i = 0; i < misItems.length; i++) {
                $("#allItemsDate").append("<tr>");                
                $("#allItemsDate").append("<td>" + misItems[i].startDate.split("T")[0] + "</td>");
                $("#allItemsDate").append("<td>" + misItems[i].devolutionDate.split("T")[0] + "</td>");
                $("#allItemsDate").append("<td>" + misItems[i].quadbike.name + "</td>");
                $("#allItemsDate").append("<td>" + misItems[i].client.name + "</td>");                                
                $("#allItemsDate").append("</tr>");
            }
        }
    });
}

function reportByStatus(){
    $("#ByStatus").removeAttr("style");    
    $("#ByClient").attr("style", "display: none");
    $("#ByDate").attr("style", "display: none");
    $.ajax({
        dataType: 'json',
        url: "http://158.101.116.78:8080/api/Reservation/report-status",
        type: "GET",
        success: function(response){            
            $("#allItemsStatus").append("<tr>");
            $("#allItemsStatus").append("<td><b>" + response.completed + "</b></td>");
            $("#allItemsStatus").append("<td><b>" + response.cancelled + "</b></td>");            
            $("#allItemsStatus").append("</tr>");
        }
    })
}

function reportByClients(){
    $("#ByClient").removeAttr("style"); 
    $("#ByStatus").attr("style", "display: none");
    $("#ByDate").attr("style", "display: none");   
    $.ajax({
        dataType: 'json',
        url: "http://158.101.116.78:8080/api/Reservation/report-clients",
        type: "GET",
        success: function(response){
            var misItems = response;
            for (let i = 0; i < misItems.length; i++) {
                $("#allItemsClients").append("<tr>");                
                $("#allItemsClients").append("<td>" + misItems[i].client.name + "</td>");
                $("#allItemsClients").append("<td>" + misItems[i].client.email + "</td>");
                $("#allItemsClients").append("<td>" + misItems[i].client.age + "</td>");
                $("#allItemsClients").append("<td>" + misItems[i].total + "</td>");                                
                $("#allItemsClients").append("</tr>");
            }
        }
    });
}

function showByDate(){
    $("#ByDate").removeAttr("style");
    $("#btnBuscar").removeAttr("style");
}


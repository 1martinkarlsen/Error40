$(document).ready(function() {
   
    Date.prototype.getWeek = function() {
        var onejan = new Date(this.getFullYear(),0,1);
        return Math.ceil((((this - onejan) / 86400000) + onejan.getDay()+1)/7);
    };
   
    jQuery(function() {
        var today = new Date();
        var weekNumber = today.getWeek();
        
        if(weekNumber >= 1 && weekNumber <= 13) {
            $('#quarter1').addClass('active');
        } else if(weekNumber >= 14 && weekNumber <= 26) {
            $('#quarter2').addClass('active');
        } else if(weekNumber >= 27 && weekNumber <= 39) {
            $('#quarter3').addClass('active');
        } else if(weekNumber >= 40 && weekNumber <= 52) {
            $('#quarter4').addClass('active');
        }
    });
   
   // Quarter 1 (13 uger)
   //       02/02-15 - 03/05-15
   
   // Quarter 2 (13 uger)
   //       04/05-15 - 02/08-15
   
   // Quarter 3  (13 uger)
   //       03/08-15 - 01/11-15
   
   // Quarter 4 (13 uger)
   //       02/11-15 - 31/01-16
});
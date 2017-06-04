/**
 * Created by kosty on 04.06.2017.
 */
;(function () {
    alert('yes');

    $("button").click(function(){
        $.getJSON("demo_ajax_json.js", function(result){
            $.each(result, function(i, field){
                $("div").append(field + " ");
            });
        });
    });
})();
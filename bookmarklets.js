javascript: (function() {alert(“hello”);})()
javascript: (function() {
    for(x=1;x<=100;x++){
        setTimeout(
            function (name){
                document.querySelector("input.new-todo").value=name;
                document.querySelector("input.new-todo").dispatchEvent(new Event('change', { 'bubbles': true }))
            }
        , x*100, "todo " + x)
    }
})()
prompt("how many?");
javascript: (function() {
    for(x=1;x<=100;x++){
        max = prompt("how many?");
        if(max){
            for(x=1;x<=max;x++){
        setTimeout(
            function (name){
                document.querySelector("input.new-todo").value=name;
                document.querySelector("input.new-todo").dispatchEvent(new Event('change', { 'bubbles': true }))
            }
        , x*100, "todo " + x)
    }
})()

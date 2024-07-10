localStorage.clear()
for(x=1;x<=100;x++){
    autoTodo.createTodo("todo "+x)
}
setTimeout(function){console.log(“hello”)},1000)
autoTodo.createTodo("hello");
setTimeout(autoTodo.createTodo("hello again"), 1000)
setTimeout(autoTodo.createTodo,1000, "hello again again again")
setTimeout(autoTodo.createTodo,5000, "hello again again again")
for(x=1;x<=100;x++){
    setTimeout(autoTodo.createTodo, x*100, "todo "+x)
}
function createTodo(name){
      document.querySelector(`input.new-todo`).value=name;
      document.querySelector(`input.new-todo`).dispatchEvent(new Event('change', { 'bubbles': true }))
}

for(x=1;x<=100;x++){
    setTimeout(createTodo, x*100, "todo "+x)

}
for(x=1;x<=100;x++){
    setTimeout(
        function (name){
            document.querySelector("input.new-todo").value=name;
            document.querySelector("input.new-todo").dispatchEvent(new Event('change', { 'bubbles': true }))
        }
    , x*100,"todo "+x)
}


function addTODO(json){
    json.forEach(element =>{
        var taskList = document.querySelectorAll(`.${element.type}`);
        subject = taskList[taskList.length-1]
        var button = `<button id = ${element.id} value = ${element.type} style = "font-size: 20px; float:right;
        margin : 9px 9px 0 0;" onclick="ajax(this)"  >→</button>`;
        var insertTag = `<li class = \"${element.type} content\"><span class = \"title\"> `
            + `${element.title} ${button}</span><br><span>등록날짜:${element.regDate} ${element.name}, `
            + `우선순위 ${element.sequence}</span></li>`;
        subject.insertAdjacentHTML("afterend",insertTag);
                 })   
} 
let addElement = element =>{
    var taskList = document.querySelectorAll(`.${element.type}`);
    subject = taskList[taskList.length-1]
    var button = `<button id = ${element.id} value = ${element.type} style = "font-size: 20px; float:right;
    margin : 9px 9px 0 0;" onclick="ajax(this)"  >→</button>`;
    var insertTag = `<li class = \"${element.type} content\"><span class = \"title\"> `
        + `${element.title} ${button}</span><br><span>등록날짜:${element.regDate} ${element.name}, `
        + `우선순위 ${element.sequence}</span></li>`;
    subject.insertAdjacentHTML("afterend",insertTag);
             };
             
function ajax(self) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        self.parentElement.parentElement.remove();
        var element = JSON.parse(this.responseText);
        var taskList = document.querySelectorAll(`.${element.type}`);
        subject = taskList[taskList.length-1]
        var button = `<button id = ${element.id} value = ${element.type} style = "font-size: 20px; float:right;
        margin : 9px 9px 0 0;" onclick="ajax(this)"  >→</button>`;
        var insertTag = `<li class = \"${element.type} content\"><span class = \"title\"> `
            + `${element.title} ${button}</span><br><span>등록날짜:${element.regDate} ${element.name}, `
            + `우선순위 ${element.sequence}</span></li>`;
        subject.insertAdjacentHTML("afterend",insertTag);
    });    
    oReq.open("GET", `http://localhost:8080/Todo/todotype?id=${self.id}&type=${self.value}`);//parameter를 붙여서 보낼수있음. 
    oReq.send();
    }

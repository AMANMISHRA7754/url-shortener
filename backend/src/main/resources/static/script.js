
const input=document.getElementById("input-url");
const submit=document.getElementById("submit");
const result=document.getElementById("result");

submit.addEventListener("click", ()=>
{
     console.log("Button clicked");
const url=input.value;
fetch("/shorten",{
    method: "POST",
    headers:{
        "Content-Type":"application/json"
    },
    body: JSON.stringify
    ({
        "url": url
    })
}).then(response => response.json()).then(data =>{
    result.textContent = data.shortUrl;
});
});

fetch(/analytics/{shortCode})
.then(response =>
{
    
}
)
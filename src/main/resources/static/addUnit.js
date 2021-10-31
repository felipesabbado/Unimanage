async function save() {
    try {
        let data = {
            name: document.getElementById("name").value,
            credits: document.getElementById("credits").value,
        };
        let res = await $.ajax({
            url: "/api/units",
            data: JSON.stringify(data),
            method: "post",
            contentType:"application/json",
            dataType: "json"
        });
        document.getElementById("message").innerHTML = JSON.stringify(res);
    } catch (error) {console.log(error);}
}
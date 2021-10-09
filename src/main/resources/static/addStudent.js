async function save() {
    try {
        let data = {
            name: document.getElementById("name").value,
            birthDate: LocalDate.parse(document.getElementById("birthDate").value),
            gender: document.getElementById("gender").value
        };
        let res = await $.ajax({
            url: "/api/students/add",
            data: JSON.stringify(data),
            method: "post",
            contentType:"application/json",
            dataType: "json"
        });
        document.getElementById("message").innerHTML = JSON.stringify(res);
    } catch (error) {console.log(error);}
}
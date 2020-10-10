const url = "https://marcge.dk/Lys-1.0.1/api/light/"

function getAllLights() {
    return fetch(url + "all").then(handleHttpErrors)
}

function addLight(light) {
    return fetch(url, makeOptions("POST", light)).then(handleHttpErrors)
}

// function deletePerson(personId) {
//     return fetch(url + personId, makeOptions("DELETE")).then(handleHttpErrors)
// }

function editLight(light) {
    return fetch(url + light.id, makeOptions("PUT", light)).then(handleHttpErrors)
}

function makeOptions(method, body) {
    var opts = {
        method: method,
        headers: {
            "Content-type": "application/json",
            "Accept": "application/json"
        }
    }
    if (body) {
        opts.body = JSON.stringify(body);
    }
    return opts;
}

function handleHttpErrors(res) {
    if (!res.ok) {
        return Promise.reject({ status: res.status, fullError: res.json() })
    }
    return res.json();
}

const personFacade = {
    getAllLights,
    addLight,
    // deletePerson,
    // getPerson,
    editLight,
}

export default personFacade
import "./style.css"
import "bootstrap/dist/css/bootstrap.css"
import LightFacade from "./LightFacade"

LightFacade.getAllLights().then(data => {
    console.log(data)
})

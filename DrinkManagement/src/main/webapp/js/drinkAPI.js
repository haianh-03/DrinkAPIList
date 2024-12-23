document.addEventListener("DOMContentLoaded", async function (){
    const path = window.location.pathname;
    console.log(path);
    if(path.endsWith("homepage.html")){
        await getBookList();
    }
    
    const params = new URLSearchParams(window.location.search);
    const drinkId = params.get('drinkID');
    
    if (drinkId) {
        console.log(`Drink ID: ${drinkId}`);
        // Gọi API để lấy chi tiết
        await getDrinkDetails(drinkId);
    }
}
);

async function getBookList() {
    console.log("loading");
    const apiUrl = "/DrinkManagement/drink/all";
    try {
        const response = await axios.get(apiUrl);
//                console.log(response);
//                console.log(response.data);
//                console.log(response.data[0]);
        const drinks = response.data;
        const tbody = document.getElementById('tableListDrink');
        for (let i = 0; i < response.data.length; i++) {
            const row = document.createElement('tr');
            row.setAttribute("onclick", "navigateToDetailsPage(" + response.data[i].drinkID + ")");
            const cellID = document.createElement('td');
//            console.log(response.data[i].drinkID);
            cellID.textContent = response.data[i].drinkID;
            const cellName = document.createElement('td');
//            console.log(response.data[i].drinkID);
            cellName.textContent = response.data[i].drinkName;
            row.appendChild(cellID);
            row.appendChild(cellName);
            tbody.appendChild(row);
        }

    } catch (error) {
        console.log(error);
    }
}

async function navigateToDetailsPage(drinkID){
    window.location.assign("drinkDetail.html?drinkID=" + encodeURIComponent(drinkID));
}

async function getDrinkDetails(drinkID) {
    console.log("hihi");
    const apiUrl = "/DrinkManagement/drink/details?drinkID=" + drinkID;
    try {
        const response = await axios.get(apiUrl);
        const drink = response.data;
        const sizeOptionsContainer = document.getElementById("sizeOptions");
        const priceElement = document.getElementById("drinkPrice");
        console.log(drink);
        document.getElementById("drink").innerText = drink.drinkID;
        document.getElementById("drinkName").innerText = drink.drinkName;
        document.getElementById("drinkDescription").innerText = drink.description;
        if(drink.topping === null){
            document.getElementById("toppingName").innerText = "(Không)";
        }else{
            document.getElementById("toppingName").innerText = drink.topping;
        }
        drink.listSizePrice.forEach(sizePrice => {
            const button = document.createElement("button");
            button.textContent = sizePrice.size;
            button.setAttribute("data-price", sizePrice.price);
            sizeOptionsContainer.appendChild(button);
        });
        
        sizeOptionsContainer.addEventListener("click", (event) => {
           if(event.target.tagName === "BUTTON"){
               const price = event.target.getAttribute("data-price");
               priceElement.textContent = price;
               
               const buttons = sizeOptionsContainer.querySelectorAll("button");
               buttons.forEach(btn => btn.classList.remove("active"));
               event.target.classList.add("active");
           } 
        });
        
        if(drink.listSizePrice.length > 0){
            const firstButton = sizeOptionsContainer.querySelector("button");
            firstButton.classList.add("active");
            priceElement.textContent = firstButton.getAttribute("data-price");
        }
    } catch (error) {
        console.log(error);
    }
}




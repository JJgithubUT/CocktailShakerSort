const lienzo = document.getElementById('lienzo');
const ctx = lienzo.getContext('2d');
const btnReiniciarDatos = document.querySelector('#btnReiniciarDatos');
const inputDatos = document.querySelector('#inputDatos');
const btnInputDatos = document.querySelector('#btnInputDatos');
const btnIniciarAlgoritmo = document.querySelector('#btnIniciarAlgoritmo');
const btnGuardarAlgoritmo = document.querySelector('#btnGuardarAlgoritmo');
const btnCargarAlgoritmo = document.querySelector('#btnCargarAlgoritmo');
const btnNumAleatorio = document.querySelector('#btnNumAleatorio');
const spanMatrizAProcesar = document.querySelector('#matrizAProcesar');
let arregloPrevio = [];

btnInputDatos.addEventListener('click', () => {
    if (inputDatos.value !== '' && !isNaN(parseFloat(inputDatos.value))) {
        arregloPrevio.push(parseFloat(inputDatos.value));
        spanMatrizAProcesar.innerText = arregloPrevio.join(', ');
        console.log(arregloPrevio);
        inputDatos.value = '';
    }
});

inputDatos.addEventListener('keydown', function(e) {
    if (e.key == 'Enter'){
        if (inputDatos.value !== '' && !isNaN(parseFloat(inputDatos.value))) {
            arregloPrevio.push(parseFloat(inputDatos.value));
            spanMatrizAProcesar.innerText = arregloPrevio;
            console.log(arregloPrevio);
            inputDatos.value = '';
        }
    }
})

function imprimirArreglo(arreglo) {
    const lienzoWidth = lienzo.width;
    const lienzoHeight = lienzo.height;

    let longitudTamanyoX = Math.round(lienzoWidth / arreglo.length);
    ctx.clearRect(0, 0, lienzoWidth, lienzoHeight);

    for (let i = 0; i < arreglo.length; i++) {
        ctx.fillStyle = `rgb(255, 0, 0, ${ arreglo[i] / Math.max(...arreglo) })`;
        const height = (arreglo[i] / Math.max(...arreglo)) * lienzoHeight * 0.9;
        ctx.fillRect(
            longitudTamanyoX * i, 
            lienzoHeight - height,
            longitudTamanyoX, 
            height
        );
        spanMatrizAProcesar.innerText = arreglo;
    }
}


async function cokkuteiruSheekaSoruto(arreglo) {
    let swapped;
    do {
        swapped = false;
        for (let i = 0; i < arreglo.length - 1; i++) {
            if (arreglo[i] > arreglo[i + 1]) {
                [arreglo[i], arreglo[i + 1]] = [arreglo[i + 1], arreglo[i]];
                swapped = true;
                imprimirArreglo(arreglo);
                await new Promise(resolve => setTimeout(resolve, 500));
            }
        }
        if (!swapped) break;
        swapped = false;
        for (let i = arreglo.length - 2; i >= 0; i--) {
            if (arreglo[i] > arreglo[i + 1]) {
                [arreglo[i], arreglo[i + 1]] = [arreglo[i + 1], arreglo[i]];
                swapped = true;
                imprimirArreglo(arreglo);
                await new Promise(resolve => setTimeout(resolve, 500));
            }
        }
    } while (swapped);
    return arreglo;
}

btnNumAleatorio.addEventListener('click', () => {
    arregloPrevio.push(Math.floor(Math.random() * 100));
    spanMatrizAProcesar.innerText = arregloPrevio.join(', ');
});

btnIniciarAlgoritmo.addEventListener('click', () => {
    if (arregloPrevio.length > 0) {
        const resultado = cokkuteiruSheekaSoruto(arregloPrevio);
        spanMatrizAProcesar.innerText = resultado.join(', ');
        console.log('Arreglo ordenado:', resultado);
    } else {
        alert('No hay datos en el arreglo.');
    }
});

btnReiniciarDatos.addEventListener('click', () => {
    location.reload();
})

btnGuardarAlgoritmo.addEventListener('click', () => {
    if (arregloPrevio !== null) {
        localStorage.setItem('arregloCocktail', JSON.stringify(arregloPrevio));
        alert('Datos guardados con éxito ;)')
    }
});

btnCargarAlgoritmo.addEventListener('click', () => {
    if (localStorage.getItem('arregloCocktail') !== null) {
        arregloPrevio = JSON.parse(localStorage.getItem('arregloCocktail'));
        spanMatrizAProcesar.innerText = arregloPrevio;
    }
});
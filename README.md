# Parcial 2 AREP

## Descripcion
En este parcial desplegaremos 3 instancias EC2, donde 2 de estas representaran un servicio matemático
donde se resuelve busqueda lineal y binaria dado un valor y una lista de numeros. Luego
tendremos el proxy el cual será el intermediario entre el cliente y el servidor.

## Comandos

```
mvn clean install
```

### Docker

```
# Para MathService
docker build -t math .
# Para Proxy
docker build -t proxy .
```

```
docker login
# Para mathService
docker tag math camilatorres0812/parcialmath
# Para Proxy
docker tag proxy camilatorres0812/parcialproxy
```

```
# Para mathService
docker push camilatorres0812/parcialmath:latest
# Para Proxy
docker push camilatorres0812/parcialproxy:latest
```

### AWS
```
sudo yum update -y
```

```
sudo yum install docker
```

```
sudo service docker start
```

```
# En las instancias de MathServices
docker run -d -p 8080:8080 --name math camilatorres0812/parcialmath
# En la de Proxy
docker run -d -p 8080:8080 --name proxy camilatorres0812/parcialproxy
```

## Evidencia despliegue

### Instancias EC2 para MathService

1. Crear 2 EC2 de MathService

<img width="1065" height="802" alt="image" src="https://github.com/user-attachments/assets/c23d6bc4-90cb-4574-9857-6325d752b5e8" />

<img width="1664" height="441" alt="image" src="https://github.com/user-attachments/assets/553fbbbe-9105-4319-92a3-8fbb2893e33e" />

2. Abrir puerto 8080

<img width="1657" height="446" alt="image" src="https://github.com/user-attachments/assets/b9ff9141-230b-4bf6-a162-1c0edc1b2825" />

3. Instalar la imagen docker y correrla

<img width="1899" height="352" alt="image" src="https://github.com/user-attachments/assets/2abe4b52-b1a2-4a59-a548-a00f1bc015c8" />

#### Pruebas Instancia 1 de MathService

<img width="807" height="121" alt="image" src="https://github.com/user-attachments/assets/e8c029ec-3d05-4bb3-958b-b1a21ef44f18" />

<img width="818" height="116" alt="image" src="https://github.com/user-attachments/assets/19ebb965-334a-4564-8cd0-b956ea54fb65" />

<img width="815" height="124" alt="image" src="https://github.com/user-attachments/assets/c32fa0d6-c232-4eeb-bf9b-5b6980cebe76" />

#### Pruebas Instancia 2 de MathService

<img width="811" height="125" alt="image" src="https://github.com/user-attachments/assets/0316757c-e10b-4501-a613-c05dc3268165" />

<img width="811" height="117" alt="image" src="https://github.com/user-attachments/assets/bf266845-c4df-4337-b829-dcc1cb3485b8" />

<img width="801" height="131" alt="image" src="https://github.com/user-attachments/assets/a5834128-4577-488a-8964-f55cc612b1bf" />

<img width="817" height="115" alt="image" src="https://github.com/user-attachments/assets/71412b76-8cfd-463f-91a8-fc9f9ab7d1d0" />

### Instancia Proxy

<img width="1121" height="771" alt="image" src="https://github.com/user-attachments/assets/5cc6d51e-d527-4977-969a-12326a52e2a2" />

<img width="1747" height="522" alt="image" src="https://github.com/user-attachments/assets/7649385c-18c0-444e-8c0e-1fc0683b5598" />

## Video

https://pruebacorreoescuelaingeduco-my.sharepoint.com/:f:/g/personal/andrea_torres-g_mail_escuelaing_edu_co/EuQRLqzZaCtBq0Rs3vxfIDoBsofJqMUIoo3zic0d4_dDWQ?e=5VmfUJ

## Autor

Andrea Camila Torres González










# buscahipoteeca

## Instalación Entorno de Desarrollo en Ubuntu 24

### Instalar Java 8 para Cliente (Active Support: March 31, 2022 | Extended Support: December 21, 2030):

```bash
sudo apt install -y openjdk-8-jdk
sudo apt install -y openjdk-8-jre-headless
```

### Instalar Java 17 para Cliente (Active Support: September 30, 2026 | Extended Support: September 30, 2029):

```bash
sudo apt install -y openjdk-8-jre-headless
sudo apt install -y openjdk-8-jdk
```

```bash
sudo apt install -y openjdk-17-jre-headless
sudo apt install -y openjdk-17-jdk
```

Trabajar con varias versiones de Java
```bash
sudo update-alternatives --config java
sudo update-alternatives --config javac
```

Comprobar version de Java
```bash
java -version
javac -version
which javaws
```
### Instalar Eclipse
## Modo 1 Instalación manual archivos:
Web descarga : https://www.eclipse.org/downloads/
ejecutar archivo `eclipse-inst`

#### Mado 2 Instalación Snap paquete
```bash
sudo snap install eclipse --classic
```

#### Instalar Java FX
Eclipse -> menu Help -> Install new software
Add
name= "e(fx)clipse"
location= "http://download.eclipse.org/efxclipse/updates-released/3.3.0/site"

Marcar casillas de los elementos.
Cargara los elementos
Aceptamos condiciones
Finish
Se instalarán los componentes y se reiniciará eclipse.

Comprobar que eclipse está instalado:
- Creando nuevo proyecto JavaFx
- File -> New -> Other
- Ventana nueva Select wizard, estará disponible JavaFx Project.
- New Java Project -> IMPORTANTE! Seleccionar Versión Java Correcta

#### Usar archivos FXML
- Creando nuevo proyecto JavaFx
- File -> New -> Other
- Ventana nueva Select wizard, estará disponible New FXML Document.

#### Scene Builder (No es compatible con Ubuntu por las librerías)
Descargar: https://gluonhq.com/products/scene-builder/
```bash
sudo dpkg -i SceneBuilder-21.0.0.deb
```
import controlador.ControladorPrincipal;
import modelo.Coleccion;
import vista.Menu;

void main() {
    Menu menu = new Menu();
    Coleccion coleccion = new Coleccion();

    ControladorPrincipal controladorPrincipal = new ControladorPrincipal(menu, coleccion);
    controladorPrincipal.iniciar();
}

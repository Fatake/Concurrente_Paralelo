public class Monitor {
    /**
     * Un monitor tiene problema
     * que cuando se llaman dos funciones de el 
     * dado que la synchronized no nos garantiza el orden de los metodos 
     * ejecutatos
     * dado que todos los synchronized de un monitor todos los metodos
     * mientras un metodo esta activo ningun otro metodo puede ser ejecutado
     * Solo hay una cola comun
     * Si garantiza que al final todo estara correcto pero el orden no
     */
    private int cont = 0;
    private int size; 
    public Monitor(int size){
        this.size = size;
    }

    public synchronized int getCont() {
        return cont;
    }

    /**
     * Cuando se pone el synchronized en una funcion y no como funcion
     * el cerrojo es el this del objeto
     * @return */
    public synchronized int incrementa(){
        for (int i = 0; i < size; i++) {
            cont ++;
        }
        return 1;
    }
}
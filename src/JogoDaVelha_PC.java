public class JogoDaVelha_PC {

    private JogoDaVelha_Mapa mapa;
    private char letra = 'O'; 
    
    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa){
        this.mapa = mapa;
    }

    public boolean joga(){
        int coluna;
        int linha;

        //Enquanto a jogada do computador não for válida, ele vai ficar no loop tentando jogar.
        do{
            linha = mapa.sortear(0, 2);
            coluna = mapa.sortear(0, 2);

        }while(!mapa.jogar(linha, coluna, letra));
        System.out.println("PC[" + linha + "," + coluna + "]");

        if(mapa.ganhou(letra)){
            System.out.println("... PC GANHOU!");
            return true;
        }
        
        return false;
    }
}

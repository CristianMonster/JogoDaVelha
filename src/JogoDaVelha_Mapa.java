public class JogoDaVelha_Mapa {
    
    private char [][] mapa = new char[3][3];
    
    public int sortear(int inicio, int fim){
        return inicio + (int)(Math.random() * ((fim - inicio) + 1));
    }

    public void limpaMapa(){
        for(int linha = 0; linha < mapa.length; linha++){
            for(int coluna = 0; coluna < mapa.length; coluna++){
                mapa[linha][coluna] = ' ';
            }    
        }
    }

    //Desenha o mapa.
    public void desenha(int jogada){
        System.out.println("------------- .. jogada: " + jogada);
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("----------------------------");
    }

    //Realiza a jogada do jogador.
    public boolean jogar(int l, int c, char jogador){
        if(l <= mapa.length && c <= mapa.length && mapa[l][c] == ' '){
            mapa[l][c] = jogador;  
            return true;  
        }
        return false;
    }

    public boolean ganhou(char jogador){
        //Verifica se o jogador ganhou marcando as 3 posições na mesma linha.
        for(int linha = 0; linha < mapa.length; linha++){
            if(mapa[linha][0] == jogador && mapa[linha][1] == jogador && mapa[linha][2] == jogador){
                return true;
            }
        }
        
        //Verifica se o jogador ganhou marcando as 3 posições na mesma coluna.
        for(int coluna = 0; coluna < mapa[0].length; coluna++){
            if(mapa[0][coluna] == jogador && mapa[1][coluna] == jogador && mapa[2][coluna] == jogador){
                return true;
            }
        }

        //Verifica se o jogador ganhou marcando a diagonal principal.
        if(mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador)
            return true;

        //Verifica se o jogador ganhou marcando a diagonal secundaria.
        return(mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador);
    }
}
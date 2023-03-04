import java.util.Scanner;

public class JogoDaVelha {
    
    private static JogoDaVelha_Mapa jogoMapa;
    private static JogoDaVelha_PC jogoPC;
    private static JogoDaVelha_Jogador jogoJogador;

    private static void jogar(Scanner teclado){
        jogoMapa.limpaMapa();
        jogoMapa.desenha(0);//Começa na jogada 0
        
        int sorteio = jogoMapa.sortear(0, 1);
        int numJogadas = 0;
        boolean jogadorComeca = sorteio == 1;
        boolean temVencedor = false;
        while(numJogadas < 9 && !temVencedor){
            temVencedor = jogadorComeca ? jogoJogador.joga(teclado) : jogoPC.joga(); 
            numJogadas++;

            jogoMapa.desenha(numJogadas);
            
            if(!temVencedor && numJogadas == 9){
                jogoMapa.desenha(numJogadas);
                System.out.println("... EMPATOU!");
            }
            jogadorComeca = !jogadorComeca;
        }
    }
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);

        jogoMapa = new JogoDaVelha_Mapa();    
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
        jogoPC = new JogoDaVelha_PC(jogoMapa);

        boolean jogarNovamente = true;

        while(jogarNovamente){
            jogar(teclado);

            while(true){
                System.out.println("Deseja jogar novamente? (s/n)");
                char resposta = teclado.next().charAt(0);

                if(Character.toLowerCase(resposta) == 'n'){
                    jogarNovamente = false;
                    break;
                } else if(Character.toLowerCase(resposta) == 's'){
                    break;
                }
                System.out.println("Resposta inválida, responda com 's' ou 'n'");
            }
        }
    }
}

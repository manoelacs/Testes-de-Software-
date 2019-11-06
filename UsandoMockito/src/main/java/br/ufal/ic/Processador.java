package br.ufal.ic;


public class Processador {
    private FonteOrigem fonteOrigem;
    private FonteDestino fonteDestino;


    public Processador(FonteOrigem fonteOrigem, FonteDestino fonteDestino) {
        this.fonteOrigem = fonteOrigem;
        this.fonteDestino = fonteDestino;
    }

    public void processaDados() throws Exception {

        String entrada = null;

        try {

            entrada = fonteOrigem.read();

        } catch (Exception ex) {

            throw new Exception("Ocorreu um problema ao ler
                    dados da fonte de origem.");

        }

        if(entrada != null) {

            String saida = transformaDados(entrada);

            try {

                fonteDestino.write(saida);

            } catch (Exception e) {
                throw new Exception("Nao foi possível enviar os dados
                        para fonte de destino.");
            }
        }

    }

    private String transformaDados(String entrada) {

        if( "[HoraAtual]".equals(entrada) ) {
            return "hora atual: " + System.currentTimeMillis();
        }

        return entrada;

    }
}

package br.com.samuelweb.nfe;

import br.com.samuelweb.certificado.Certificado;
import br.com.samuelweb.certificado.CertificadoService;
import br.com.samuelweb.nfe.dom.ConfiguracoesIniciaisNfe;
import br.com.samuelweb.nfe.util.Ambiente;
import br.com.samuelweb.nfe.util.CertificadoUtil;
import br.com.samuelweb.nfe.util.Estados;
import br.com.samuelweb.nfe.util.Tipo;
import br.com.samuelweb.nfe.util.XmlUtil;
import br.inf.portalfiscal.nfe.schema_4.enviNFe.TEnviNFe;
import br.inf.portalfiscal.nfe.schema_4.enviNFe.TRetEnviNFe;
import br.inf.portalfiscal.nfe.schema_4.retConsReciNFe.TRetConsReciNFe;

public class Main {

	public static void main(String argv[]) throws Exception {
		Certificado c = CertificadoService.certificadoPfx("c:\\CERTIFICADO_MG.pfx", "barbara100");
		ConfiguracoesIniciaisNfe.iniciaConfiguracoes(Estados.GO, Ambiente.HOMOLOGACAO, c, null);

		CertificadoUtil.iniciaConfiguracoes();

		TEnviNFe enviNfe = XmlUtil.xmlToObject(XmlUtil.leXml("xml.xml"), TEnviNFe.class);

		enviNfe = Nfe.montaNfe(enviNfe, false);
		TRetEnviNFe retorno = Nfe.enviarNfe(enviNfe);
		System.out.println(retorno.getCStat());
		System.out.println(retorno.getXMotivo());
		System.out.println(retorno);

		TRetConsReciNFe consultaRecibo = Nfe.consultaRecibo(retorno.getInfRec().getNRec(), Tipo.NFE);
		while (consultaRecibo.getCStat().equals("105")) {
			System.out.println(consultaRecibo.getCStat());
			System.out.println(consultaRecibo.getXMotivo());
			System.out.println(consultaRecibo);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}

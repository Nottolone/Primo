<%-- 
    Document   : descrizione
    Created on : 27-apr-2016, 17.49.56
    Author     : Matteo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Descrizione</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Matteo Porcu">
        <meta name="description" content="Descrizione del sito">
        <meta name="keywords" content="descrizione, funzionamento, come">
        <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div id="content">
            <h2>Descrizione</h2>
            
            <p>Questo &egrave; un sito per l'acquisto di prodotti online. Il sito offre sezioni per varie tipologie di prodotti: CD musicali, videocassette, DVD, software, elettronica, oggetti da cucina, ferramenta, articoli da giardinaggio, giocattoli, prodotti per neonati, abbigliamento, articoli sportivi, gastronomia, gioielli, orologi, articoli per l'igiene personale, cosmetici, strumenti musicali, forniture per uso industriale e scientifico.</p>

            <ol>
                <li><a href='#funz'>Funzionamento</a></li>
                <li><a href='#primo'>Acquirenti</a></li>
                <li><a href='#secondo'>Venditori</a></li>
            </ol>

            <h3 id='funz'>Funzionamento</h3>
            <p>Sul sito sono vigenti due regole fondamentali: ricezione della merce solo dopo il pagamento (ecco spiegata l'importanza dei feedback e delle varie reputazioni venditore/compratore); alcuni accettano il contro assegno ma sono una minoranza, e le spese di spedizione (salvo diversa indicazione e/o promozioni del venditore) sono sempre a carico dell'acquirente.</p>
            <h3 id='primo'>Acquirenti</h3>
            <p>Per essere acquirenti basta registrarsi sul sito, fornendo solo alcuni dati essenziali; a questo punto si pu&ograve; subito cominciare a fare acquisti. L'acquirente ha l'obbligo di pagare entro tempi ragionevoli e/o di dare eventuali comunicazioni su eventuali problemi per il saldo della transazione: in caso di insolvenza sar&agrave; a discrezione del venditore (eventualmente dopo l'apertura di una controversia) se concludere la transazione senza conseguenze o stimolare l'acquirente ad adempiere il suo compito. L'utente che acquista gode però anche di diritti chiari e precisi: ricevere la merce entro i tempi stabiliti (da una settimana a massimo un mese), la merce deve corrispondere alla descrizione e all'eventuale foto dell'inserzione ed essere integra.</p>
            <h3 id='secondo'>Venditori</h3>
            <p>Un venditore pu&ograve; decidere di vendere oggetti propri usati o di aprire un negozio virtuale online: in ogni caso deve fare la richiesta d'ammissione come venditore non professionale o professionale. Professionali o no i venditori devono sempre creare inserzioni corrette (niente spese extra), veritiere (quello che viene descritto deve corrispondere a ci&ograve; che viene spedito) e legali (non si possono, ad esempio, vendere armi o animali vivi). La responsabilit&agrave; degli oggetti venduti, ai sensi di legge, &egrave; totalmente del venditore; in caso di acquirente scorretto o insolvente il venditore (che non ha spedito l'oggetto) se apre una controversia pu&ograve; farsi rimborsare il costo dell'inserzione e delle commissioni per la mancata vendita; alcuni venditori vietano a utenti con un numero di feedback negativo (cioè inferiore a 0) l'acquisto o la partecipazione alle loro aste, al fine di tutelarsi.</p>
        </div>
        
        <div id="navigazione">
            <h2>Navigazione</h2>
            <ul>
                <li><a href="login.html">Login</a></li>
            </ul>
        </div>
        
        <jsp:include page="barradestra.jsp"/>
    </body>
</html>

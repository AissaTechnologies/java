package com.aissa.aissatech.util;

/**
 * @author Camelia Boban
 *
 */

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;

public class ImageWrapper implements DisplaytagColumnDecorator
{
	private String commento;

    /**
     * crea la stringa per la visualizzazione dell'immagine con relativo alternate text
     * @see org.displaytag.decorator.DisplaytagColumnDecorator#decorate(Object, PageContext, MediaTypeEnum)
     */
    public Object decorate(Object value, PageContext pageContext, MediaTypeEnum media) throws DecoratorException
    {
    	
		if (value.equals("info.png")){	
   			this.commento = "Dettaglio";
    	}		
		if (value.equals("edit.png")){	
   			this.commento = "Modifica";	
		}		
		if (value.equals("remove.png")){	
   			this.commento = "Cancella";
    	}
		if (value.equals("first.png")){	
   			this.commento = "Primo";
    	}
		if (value.equals("prev.png")){	
   			this.commento = "Precedente";
    	}
		if (value.equals("next.png")){	
   			this.commento = "Prossimo";
    	}
		if (value.equals("last.png")){	
   			this.commento = "Ultimo";
    	}
		if (value.equals("approva.png")){	
   			this.commento = "Approva il consolidamento";
    	}
		if (value.equals("respingi.png")){	
   			this.commento = "Respingi il consolidamento";
    	}
		if (value.equals("cons_mese.png")){	
   			this.commento="Consolida il mese";
    	}
		
		String imgSrc ="<img src=images/" + value + " border=0 " + "alt = " + commento + ">";		
		//<img src="images/edit.png" border="0" alt="">
    	
    	return imgSrc;

    }

}

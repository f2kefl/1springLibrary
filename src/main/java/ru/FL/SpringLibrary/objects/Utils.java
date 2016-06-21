package ru.FL.SpringLibrary.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.FL.SpringLibrary.enums.SearchType;

import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by F4KEFLY on 09.06.2016.
 * Description:
 * TODO:
 */
@Component
@Scope("singleton")
public class Utils
{
    private Map<String, SearchType> searchTypeMap = new HashMap<String, SearchType>();
    private String searchString;

    @Autowired
    private MessageSource msg;

    private Character[] letters = new Character[]{'À', 'Á', 'Â', 'Ã', 'Ä', 'Å', '¨', 'Æ', 'Ç', 'È', 'É', 'Ê', 'Ë', 'Ì',
            'Í', 'Î', 'Ï', 'Ð', 'Ñ', 'Ò', 'Ó', 'Ô', 'Õ', 'Ö', '×', 'Ø', 'Ù', 'Ú', 'Û', 'Ü', 'Ý', 'Þ', 'ß'};

    public Character[] getLetters()
    {
        return letters;
    }

    public Map<String, SearchType> getSearchTypeMap()
    {
        searchTypeMap.clear();
        searchTypeMap.put(msg.getMessage("author_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.AUTHOR);
        searchTypeMap.put(msg.getMessage("book_name", null, FacesContext.getCurrentInstance().getViewRoot().getLocale()), SearchType.TITLE);
        return searchTypeMap;
    }

    public void setSearchTypeList(Map<String, SearchType> searchTypeMap)
    {
        this.searchTypeMap = searchTypeMap;
    }

    public String getSearchString()
    {
        return searchString;
    }

    public void setSearchString(String searchString)
    {
        this.searchString = searchString;
    }
}
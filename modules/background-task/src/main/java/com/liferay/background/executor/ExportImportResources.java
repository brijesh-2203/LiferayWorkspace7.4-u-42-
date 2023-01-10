package com.liferay.background.executor;

import com.liferay.docs.guestbook.portlet.constants.GuestbookPortletKeys;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK_ADMIN,
                "javax.portlet.name=" + GuestbookPortletKeys.GUESTBOOK,
                "mvc.command.name=/exportEntry"
        },
        service = MVCResourceCommand.class
)
public class ExportImportResources implements MVCResourceCommand {



    public static String[] columnNames = { "UserId", "FirstName", "LastName","EmailAddress", "Screen Name" };
    public static final String CSV_SEPARATOR = ",";
    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
        ThemeDisplay themeDisplay  =(ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        System.out.println("Servce Resources from MVC Only serve");
//        ServiceContext serviceContext = null;
        try {
//            serviceContext = ServiceContextFactory.getInstance(
//                    Entry.class.getName(), resourceRequest);
//            System.out.println("service ");
//            long backgroundTaskId = ParamUtil.getLong(resourceRequest, "backgroundTaskId");
//            System.out.println("backgroundTaskId  :  "+backgroundTaskId);
//
//            BackgroundTask backgroundTask1 = BackgroundTaskManagerUtil.getBackgroundTask(backgroundTaskId);
//            System.out.println("BaCKgroundTask Resources: " + backgroundTask1);
//            List<FileEntry> fileEntryList = backgroundTask1.getAttachmentsFileEntries();
//            System.out.println("files Resources: " + fileEntryList);
//            System.out.println("Resources file count: " + backgroundTask1.getAttachmentsFileEntriesCount());
//
//            FileEntry file = fileEntryList.get(0);
//            InputStream output = file.getContentStream();
////            DataInputStream dataInputStr
////                    = new DataInputStream(output);
////
////            // Count the total bytes
////            // form the input stream
////            int count = (int) file.getSize();
//
//            // Create byte array
//            byte[] b = output.readAllBytes();
//
//            // Read data into byte array
////            int bytes = dataInputStr.read(b);
////
////            // Print number of bytes
////            // actually read
////            System.out.println(bytes);
//
//            for (byte by : b) {
//                // Print the character
//                System.out.print((char)by);
//            }
////            BufferedReader br
////                    = new BufferedReader(new FileReader((File) file));
////
////            // Declaring a string variable
////            String st;
////            // Condition holds true till
////            // there is character in a string
////            while ((st = br.readLine()) != null) {
////                // Print the string
////                System.out.println("data: "+st);
////            }
//            String contentType = ContentTypes.APPLICATION_TEXT;
//
//
//            List<Entry> entryList = EntryLocalServiceUtil.getEntries(0,EntryLocalServiceUtil.getEntriesCount());
//            String[] columnNames = { "UserId","GroupId", "GuestbookId", "EntryId","Name","Email","Message"};
//
//            final String COMMA = ",";
//
//
//            StringBundler sb = new StringBundler();
//
//            for (String columnName : columnNames) {
//
//                sb.append(getCSVFormattedValue(columnName));
//
//                sb.append(COMMA);
//
//            }
//            sb.setIndex(sb.index() - 1);
//            sb.append(CharPool.NEW_LINE);
//            for(Entry entry : entryList)
//            {
//                sb.append(getCSVFormattedValue(String.valueOf(entry.getUserId())));
//                sb.append(COMMA);
//                sb.append(getCSVFormattedValue(String.valueOf(entry.getGuestbookId())));
//                sb.append(COMMA);
//                sb.append(getCSVFormattedValue(String.valueOf(entry.getEntryId())));
//                sb.append(COMMA);
//                sb.append(getCSVFormattedValue(entry.getName()));
//                sb.append(COMMA);
//                sb.append(getCSVFormattedValue(entry.getEmail()));
//                sb.append(COMMA);
//                sb.append(getCSVFormattedValue(entry.getMessage()));
//                sb.append(COMMA);
//
//                sb.setIndex(sb.index() - 1);
//
//                sb.append(CharPool.NEW_LINE);
//            }
//
//            byte[] bytes = sb.toString().getBytes();
//            for (byte by : bytes) {
//                // Print the character
//                System.out.print((char)by);
//            }
//            PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
//                    "fileName.csv", bytes, contentType);

//            PortletResponseUtil.sendFile(resourceRequest, resourceResponse, file.getFileName(), bytes,contentType);


        StringBundler sb = new StringBundler();
        for (String columnName : columnNames) {
            sb.append(getCSVFormattedValue(columnName));
            sb.append(CSV_SEPARATOR);
        }
        sb.setIndex(sb.index() - 1);
        sb.append(CharPool.NEW_LINE);
        List<User> usersList = UserLocalServiceUtil.getUsers(0,
                UserLocalServiceUtil.getUsersCount());
        for (User user : usersList) {
            sb.append(
                    getCSVFormattedValue(String.valueOf(user.getUserId())));
            sb.append(CSV_SEPARATOR);
            sb.append(
                    getCSVFormattedValue(String.valueOf(user.getFirstName())));
            sb.append(CSV_SEPARATOR);
            sb.append(
                    getCSVFormattedValue(String.valueOf(user.getLastName())));
            sb.append(CSV_SEPARATOR);
            sb.append(getCSVFormattedValue(String.valueOf(user
                    .getEmailAddress())));
            sb.append(CSV_SEPARATOR);
            sb.append(
                    getCSVFormattedValue(String.valueOf(user.getScreenName())));
            sb.append(CSV_SEPARATOR);
            sb.setIndex(sb.index() - 1);
            sb.append(CharPool.NEW_LINE);
        }

        String fileName = "portalUsers.csv";
        byte[] bytes = sb.toString().getBytes();
        String contentType = ContentTypes.APPLICATION_TEXT;
        PortletResponseUtil.sendFile(resourceRequest, resourceResponse,
                fileName, bytes, contentType);

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    protected String getCSVFormattedValue(String value) {
        StringBundler sb = new StringBundler();
        sb.append(CharPool.QUOTE);
        sb.append(StringUtil.replace(value, CharPool.QUOTE,
                StringPool.DOUBLE_QUOTE));
        sb.append(CharPool.QUOTE);
        return sb.toString();
    }
}

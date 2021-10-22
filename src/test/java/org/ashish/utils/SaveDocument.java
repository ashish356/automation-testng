package org.ashish.utils;


import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SaveDocument {


        private static XWPFParagraph[] pars;

        public static void createDoc(String testCaseName, String[] imgFileNames) throws Exception {


            XWPFDocument document = new XWPFDocument();
            // create a paragraph with justify alignment
            XWPFParagraph p1 = document.createParagraph();
            // first line indentation in the paragraph
            //p1.setFirstLineIndent(400);
            // justify alignment
            p1.setAlignment(ParagraphAlignment.LEFT);
            // wrap words
            p1.setWordWrapped(true);
            // XWPFRun object defines a region of text with a common set of
            // properties
            XWPFRun r1 = p1.createRun();
            r1.setText(testCaseName);


            FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + "/testResultsDocFile/" + testCaseName + ".docx"));

            //header text

            CTP ctP = CTP.Factory.newInstance();
            CTText t = ctP.addNewR().addNewT();

            t.setStringValue("Cyclops");

            pars = new XWPFParagraph[1];

            p1 = new XWPFParagraph(ctP, document);
            pars[0] = p1;


            XWPFHeaderFooterPolicy headerFooterPolicy = document.createHeaderFooterPolicy();
            headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, pars);


            ctP = CTP.Factory.newInstance();
            t = ctP.addNewR().addNewT();

            //footer text

            t.setStringValue("Ashish Automation");
            pars[0] = new XWPFParagraph(ctP, document);

            headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, pars);

            //System.out.println("image file name length "+imgFileNames.length);


            for (int i = 0; i < imgFileNames.length; i++)
            // for (String file : imgFileNames)

            {
                // Insert each image file to the document
                // System.out.println(imgFileNames[i]);
                r1.addBreak();
                r1.addBreak();



                r1.setText("Screenshot : " + imgFileNames[i]);
                r1.addBreak();
                r1.addBreak();

                File image = new File(System.getProperty("user.dir") + "/screenshots/" + imgFileNames[i] + ".png");

                //System.out.println("Image is : "+image);

                BufferedImage bimg = ImageIO.read(image);
                int width = (bimg.getWidth())/4;
                int height= (bimg.getHeight())/3;

                // System.out.println("Width is " +width);
                // System.out.println("Height is " +height);


                String imgFile = image.getName();
                int imgFormat = getImageFormat(imgFile);

                r1.addPicture(new FileInputStream(image), imgFormat,imgFile, Units.toEMU(width), Units.toEMU(height));




                //BufferedImage bimg1 = ImageIO.read();
                //int width1 = bimg1.getWidth();
                // int height1 = bimg1.getHeight();


                //myDoc.addEle(Paragraph.with("Screenshot :" + imgFileNames[i]).create());
                // myDoc.addEle(Image
                //   .from_FULL_LOCAL_PATHL(System.getProperty("user.dir") + "/screenshots/" + imgFileNames[i] + ".png")
                //  .setHeight("350").setWidth("500").getContent());

                // Insert 2 linebreaks at the end of each inserted image

                //r1.addBreak(BreakType.PAGE);
                // myDoc.addEle(BreakLine.times(2).create());
            }


            document.write(out);
            out.close();
           // System.out.println("word doc written successfully");

        }

        private static int getImageFormat(String imgFileName) {
            int format;
            if (imgFileName.endsWith(".emf"))
                format = XWPFDocument.PICTURE_TYPE_EMF;
            else if (imgFileName.endsWith(".wmf"))
                format = XWPFDocument.PICTURE_TYPE_WMF;
            else if (imgFileName.endsWith(".pict"))
                format = XWPFDocument.PICTURE_TYPE_PICT;
            else if (imgFileName.endsWith(".jpeg") || imgFileName.endsWith(".jpg"))
                format = XWPFDocument.PICTURE_TYPE_JPEG;
            else if (imgFileName.endsWith(".png"))
                format = XWPFDocument.PICTURE_TYPE_PNG;
            else if (imgFileName.endsWith(".dib"))
                format = XWPFDocument.PICTURE_TYPE_DIB;
            else if (imgFileName.endsWith(".gif"))
                format = XWPFDocument.PICTURE_TYPE_GIF;
            else if (imgFileName.endsWith(".tiff"))
                format = XWPFDocument.PICTURE_TYPE_TIFF;
            else if (imgFileName.endsWith(".eps"))
                format = XWPFDocument.PICTURE_TYPE_EPS;
            else if (imgFileName.endsWith(".bmp"))
                format = XWPFDocument.PICTURE_TYPE_BMP;
            else if (imgFileName.endsWith(".wpg"))
                format = XWPFDocument.PICTURE_TYPE_WPG;
            else {
                return 0;
            }
            return format;
        }

    }

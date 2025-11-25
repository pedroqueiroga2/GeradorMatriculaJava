/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matricula;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.io.File; // Importado para obter o caminho completo
import java.io.IOException;
import java.io.FileOutputStream;

/**
 *
 * @author Pedro
 */
public class ExcelGenerator {
    public static void geradorArquivo(List<Usuario> users, String filepath)throws IOException 
    {
        Workbook workbook = new XSSFWorkbook(); //aqui cria o arquivo .xlsx
        Sheet sheet = workbook.createSheet("Relatório de Matrículas"); // nomeando
        
        // --- CABEÇALHO ---
        Row headerRow = sheet.createRow(0); //cria a primeira linha
        
        String[] headers = {"Nome", "Sobrenome", "Idade", "Número da matricula"}; // adicionando nome linhas
        
        CellStyle headerStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true); // adicionando bold ao texto
        headerStyle.setFont(headerFont);
        for(int i = 0; i<headers.length; i++)
        {
            Cell cell = headerRow.createCell(i); // Cria uma célula na linha 0
            cell.setCellValue(headers[i]);       // Define o texto do cabeçalho
            cell.setCellStyle(headerStyle);      // Aplica o estilo negrito
            sheet.autoSizeColumn(i);             // Ajusta a largura da coluna para caber o texto
        }
        
        // --- DADOS ---
        int rowNum = 1;
        for (Usuario user : users)
        {
            Row row = sheet.createRow(rowNum++); // Cria nova linha e incrementa o contador
            
    
                row.createCell(0).setCellValue(user.getNome()); // pega o nome e seta na coluna posição 0
                row.createCell(1).setCellValue(user.getSobrenome());// pega o sobrenome e seta na coluna posição 1
                row.createCell(2).setCellValue(user.getIdade()); // pega a idade e seta na coluna posição 2
                row.createCell(3).setCellValue(user.getMatricula()); // pega a idade e seta na coluna posição 3
    

    
        }
        
               // escrever no arquivo
               
               FileOutputStream fileout = new FileOutputStream(filepath);
               workbook.write(fileout);
               workbook.close();
    }
    
    
}

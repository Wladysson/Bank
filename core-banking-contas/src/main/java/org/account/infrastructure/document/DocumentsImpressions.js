const puppeteer = require("puppeteer");
const fs = require("fs");
const path = require("path");

async function generatePDF() {
    const browser = await puppeteer.launch({
        headless: "new"
    });

    const page = await browser.newPage();

    // ===== MOCK DATA (depois vem do Java via JSON) =====
    const data = {
        accountId: "123-456",
        transactions: [
            {
                date: "2026-03-18",
                type: "DEPOSIT",
                amount: "1000.00",
                balance: "1000.00"
            },
            {
                date: "2026-03-19",
                type: "WITHDRAW",
                amount: "200.00",
                balance: "800.00"
            }
        ]
    };

    // ===== LOAD TEMPLATE =====
    const templatePath = path.join(__dirname, "templates", "statement.html");
    let html = fs.readFileSync(templatePath, "utf-8");

    // ===== INJECT DATA =====
    html = html.replace("{{accountId}}", data.accountId);

    const rows = data.transactions.map(tx => `
        <tr>
            <td>${tx.date}</td>
            <td>${tx.type}</td>
            <td>${tx.amount}</td>
            <td>${tx.balance}</td>
        </tr>
    `).join("");

    html = html.replace("{{transactions}}", rows);

    // ===== RENDER PAGE =====
    await page.setContent(html, { waitUntil: "networkidle0" });

    // ===== GENERATE PDF =====
    const outputPath = path.join(__dirname, "output", "statement.pdf");

    await page.pdf({
        path: outputPath,
        format: "A4",
        printBackground: true
    });

    await browser.close();

    console.log("PDF gerado em:", outputPath);
}

generatePDF();
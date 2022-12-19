app.get("/", async (req, res) => {
    const clientId = process.env.CLIENT_ID;
    const clientToken = await paypal.generateClientToken();
    res.render("checkout", { clientId, clientToken });
});
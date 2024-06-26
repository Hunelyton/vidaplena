document.addEventListener('DOMContentLoaded', () => {
    const checkbox = document.getElementById('checkbox');
    const bodyElement = document.body;
    
    function applyTheme(lightTheme) {
        bodyElement.classList.toggle('light-theme', lightTheme);
        localStorage.setItem('theme', lightTheme ? 'light-theme' : '');
    }

    checkbox.addEventListener('change', function() {
        applyTheme(this.checked);
    });

    const currentTheme = localStorage.getItem('theme');
    if (currentTheme) {
        bodyElement.classList.add(currentTheme);
        checkbox.checked = (currentTheme === 'light-theme');
    }

    // Função para redirecionar para outra página
    function redirect() {
       
        window.location.href = 'static/cadastroaluno/cadastroaluno.html';
    }
});

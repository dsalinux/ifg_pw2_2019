$(".menu-button-toggle").click(function(menuButton){
    if (window.matchMedia("(max-width: 700px)").matches) {
        $("body").toggleClass("sidebar-open");
        menuButton.preventDefault();
    } else {
      $("body").toggleClass("sidebar-active");
        menuButton.preventDefault();
    }
});
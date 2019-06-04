$(".menu-button-toggle").click(function(menuButton){
    if (window.matchMedia("(max-width: 700px)").matches) {
        $("body").toggleClass("sidebar-open");
        menuButton.preventDefault();
    } else {
      $("body").toggleClass("sidebar-active");
        menuButton.preventDefault();
    }
});

$(".submenu-toogle").click(function(event){
    event.preventDefault();
    submenuTarget = $(this).attr("submenu_target");
    $("#"+submenuTarget).toggleClass("open");
});
$(document).ready(function() {
    $(document).on("foundation-contentloaded", function (e) {
        showHideCtaButtonFields($(".cmp-cta__editor-show-button", e.target));
    });

    $(document).on("change", ".cmp-cta__editor-show-button", function (e) {
        showHideCtaButtonFields($(this));
    });

    function showHideCtaButtonFields(checkbox){
        let dialog = checkbox.parent();
        let container = dialog.find('.cmp-cta__editor-container-button');

        if(checkbox.prop('checked')){
            container.show();
        }else{
            container.hide();
        }
    }
});

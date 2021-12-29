package com.etiya.ReCapProject.Utilities;

import com.etiya.ReCapProject.dataAccess.abstracts.LanguageDao;
import com.etiya.ReCapProject.dataAccess.abstracts.TranslationDao;
import com.etiya.ReCapProject.dataAccess.abstracts.WordDao;
import com.etiya.ReCapProject.entities.concretes.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TranslationDataLoader implements CommandLineRunner {

    private TranslationDao translationDao;
    private LanguageDao languageDao;
    private WordDao wordDao;

    @Autowired
    public TranslationDataLoader(TranslationDao translationDao, LanguageDao languageDao, WordDao wordDao) {
        this.translationDao = translationDao;
        this.languageDao = languageDao;
        this.wordDao = wordDao;
    }



    @Override
    public void run(String... args) throws Exception {
        loadTranslationData();
    }

    private void loadTranslationData(){

        if (translationDao.count()==0) {
            var english = languageDao.getLanguagesByName("English");
            if (english == null){
                english = languageDao.getLanguagesByName("English");
            }
            //-----Brand-------
            Translation brandAddedEnglishTranslation = new Translation();
            brandAddedEnglishTranslation.setLanguage(english);
            var brandAddedEnglish = this.wordDao.getWordsByKey("brand.added");
            brandAddedEnglishTranslation.setWord(brandAddedEnglish);
            brandAddedEnglishTranslation.setTranslation("Brand Added");
            this.translationDao.save(brandAddedEnglishTranslation);

            Translation brandUpdatedEnglishTranslation = new Translation();
            brandUpdatedEnglishTranslation.setLanguage(english);
            var brandUpdatedEnglish = this.wordDao.getWordsByKey("brand.updated");
            brandUpdatedEnglishTranslation.setWord(brandUpdatedEnglish);
            brandUpdatedEnglishTranslation.setTranslation("Brand updated");
            this.translationDao.save(brandUpdatedEnglishTranslation);

            Translation brandDeletedEnglishTranslation = new Translation();
            brandDeletedEnglishTranslation.setLanguage(english);
            var brandDeletedEnglish = this.wordDao.getWordsByKey("brand.deleted");
            brandDeletedEnglishTranslation.setWord(brandDeletedEnglish);
            brandDeletedEnglishTranslation.setTranslation("Brand Deleted");
            this.translationDao.save(brandDeletedEnglishTranslation);

            Translation brandsListedEnglishTranslation = new Translation();
            brandsListedEnglishTranslation.setLanguage(english);
            var brandsListedEnglish = this.wordDao.getWordsByKey("brands.listed");
            brandsListedEnglishTranslation.setWord(brandsListedEnglish);
            brandsListedEnglishTranslation.setTranslation("Brands Listed");
            this.translationDao.save(brandsListedEnglishTranslation);

            Translation brandFoundEnglishTranslation = new Translation();
            brandFoundEnglishTranslation.setLanguage(english);
            var brandfoundEnglish = this.wordDao.getWordsByKey("brand.found");
            brandFoundEnglishTranslation.setWord(brandfoundEnglish);
            brandFoundEnglishTranslation.setTranslation("Brand Found");
            this.translationDao.save(brandFoundEnglishTranslation);

            Translation brandNotFoundEnglishTranslation = new Translation();
            brandNotFoundEnglishTranslation.setLanguage(english);
            var brandNotFoundEnglish = this.wordDao.getWordsByKey("brand.not.found");
            brandNotFoundEnglishTranslation.setWord(brandNotFoundEnglish);
            brandNotFoundEnglishTranslation.setTranslation("Brand Not Found");
            this.translationDao.save(brandNotFoundEnglishTranslation);

            Translation brandExistsEnglishTranslation = new Translation();
            brandExistsEnglishTranslation.setLanguage(english);
            var brandExistsEnglish = this.wordDao.getWordsByKey("brand.exists");
            brandExistsEnglishTranslation.setWord(brandExistsEnglish);
            brandExistsEnglishTranslation.setTranslation("Brand Exists");
            this.translationDao.save(brandExistsEnglishTranslation);

            //-------------Color-------------

            Translation colorAddedEnglishTranslation = new Translation();
            colorAddedEnglishTranslation.setLanguage(english);
            var colorAddedEnglish = this.wordDao.getWordsByKey("color.added");
            colorAddedEnglishTranslation.setWord(colorAddedEnglish);
            colorAddedEnglishTranslation.setTranslation("Color Added");
            this.translationDao.save(colorAddedEnglishTranslation);

            Translation colorUpdatedEnglishTranslation = new Translation();
            colorUpdatedEnglishTranslation.setLanguage(english);
            var colorUpdatedEnglish = this.wordDao.getWordsByKey("color.updated");
            colorUpdatedEnglishTranslation.setWord(colorUpdatedEnglish);
            colorUpdatedEnglishTranslation.setTranslation("Color Updated");
            this.translationDao.save(colorUpdatedEnglishTranslation);

            Translation colorDeletedEnglishTranslation = new Translation();
            colorDeletedEnglishTranslation.setLanguage(english);
            var colorDeletedEnglish = this.wordDao.getWordsByKey("color.deleted");
            colorDeletedEnglishTranslation.setWord(colorDeletedEnglish);
            colorDeletedEnglishTranslation.setTranslation("Color Deleted");
            this.translationDao.save(colorDeletedEnglishTranslation);

            Translation colorsListedEnglishTranslation = new Translation();
            colorsListedEnglishTranslation.setLanguage(english);
            var colorsListedEnglish = this.wordDao.getWordsByKey("colors.listed");
            colorsListedEnglishTranslation.setWord(colorsListedEnglish);
            colorsListedEnglishTranslation.setTranslation("Colors Listed");
            this.translationDao.save(colorsListedEnglishTranslation);

            Translation colorFoundEnglishTranslation = new Translation();
            colorFoundEnglishTranslation.setLanguage(english);
            var colorFoundEnglish = this.wordDao.getWordsByKey("color.found");
            colorFoundEnglishTranslation.setWord(colorFoundEnglish);
            colorFoundEnglishTranslation.setTranslation("Color Found");
            this.translationDao.save(colorFoundEnglishTranslation);

            Translation colorNotFoundEnglishTranslation = new Translation();
            colorNotFoundEnglishTranslation.setLanguage(english);
            var colorNotFoundEnglish = this.wordDao.getWordsByKey("color.not.found");
            colorNotFoundEnglishTranslation.setWord(colorNotFoundEnglish);
            colorNotFoundEnglishTranslation.setTranslation("Color Not Found");
            this.translationDao.save(colorNotFoundEnglishTranslation);

            Translation colorExistsEnglishTranslation = new Translation();
            colorExistsEnglishTranslation.setLanguage(english);
            var colorExistsEnglish = this.wordDao.getWordsByKey("color.already.exists");
            colorExistsEnglishTranslation.setWord(colorExistsEnglish);
            colorExistsEnglishTranslation.setTranslation("Color Already Exists");
            this.translationDao.save(colorExistsEnglishTranslation);

            //--------------------------Car--------------------------


            Translation carAddedEnglishTranslation = new Translation();
            carAddedEnglishTranslation.setLanguage(english);
            var carAddedEnglish = this.wordDao.getWordsByKey("car.added");
            carAddedEnglishTranslation.setWord(carAddedEnglish);
            carAddedEnglishTranslation.setTranslation("Car Added");
            this.translationDao.save(carAddedEnglishTranslation);

            Translation carUpdatedEnglishTranslation = new Translation();
            carUpdatedEnglishTranslation.setLanguage(english);
            var carUpdatedEnglish = this.wordDao.getWordsByKey("car.updated");
            carUpdatedEnglishTranslation.setWord(carUpdatedEnglish);
            carUpdatedEnglishTranslation.setTranslation("Car Updated");
            this.translationDao.save(carUpdatedEnglishTranslation);

            Translation carDeletedEnglishTranslation = new Translation();
            carDeletedEnglishTranslation.setLanguage(english);
            var carDeletedEnglish = this.wordDao.getWordsByKey("car.deleted");
            carDeletedEnglishTranslation.setWord(carDeletedEnglish);
            carDeletedEnglishTranslation.setTranslation("Car Deleted");
            this.translationDao.save(carDeletedEnglishTranslation);

            Translation carExistsEnglishTranslation = new Translation();
            carExistsEnglishTranslation.setLanguage(english);
            var carExistsEnglish = this.wordDao.getWordsByKey("car.exists");
            carExistsEnglishTranslation.setWord(carExistsEnglish);
            carExistsEnglishTranslation.setTranslation("Car Exists");
            this.translationDao.save(carExistsEnglishTranslation);

            Translation carFoundEnglishTranslation = new Translation();
            carFoundEnglishTranslation.setLanguage(english);
            var carFoundEnglish = this.wordDao.getWordsByKey("car.found");
            carFoundEnglishTranslation.setWord(carFoundEnglish);
            carFoundEnglishTranslation.setTranslation("Car Found");
            this.translationDao.save(carFoundEnglishTranslation);

            Translation carsListedEnglishTranslation = new Translation();
            carsListedEnglishTranslation.setLanguage(english);
            var carListedEnglish = this.wordDao.getWordsByKey("cars.listed");
            carsListedEnglishTranslation.setWord(carListedEnglish);
            carsListedEnglishTranslation.setTranslation("Cars Listed");
            this.translationDao.save(carsListedEnglishTranslation);

            Translation carNotFoundEnglishTranslation = new Translation();
            carNotFoundEnglishTranslation.setLanguage(english);
            var carNotFoundEnglish = this.wordDao.getWordsByKey("car.not.found");
            carNotFoundEnglishTranslation.setWord(carNotFoundEnglish);
            carNotFoundEnglishTranslation.setTranslation("Car Not Found");
            this.translationDao.save(carNotFoundEnglishTranslation);


            //-----------------CITY----------------------------

            Translation cityAddedEnglishTranslation = new Translation();
            cityAddedEnglishTranslation.setLanguage(english);
            var cityAddedEnglish = this.wordDao.getWordsByKey("city.added");
            cityAddedEnglishTranslation.setWord(cityAddedEnglish);
            cityAddedEnglishTranslation.setTranslation("City Added");
            this.translationDao.save(cityAddedEnglishTranslation);

            Translation cityUpdatedEnglishTranslation = new Translation();
            cityUpdatedEnglishTranslation.setLanguage(english);
            var cityUpdateEnglish = this.wordDao.getWordsByKey("city.updated");
            cityUpdatedEnglishTranslation.setWord(cityUpdateEnglish);
            cityUpdatedEnglishTranslation.setTranslation("City Updated");
            this.translationDao.save(cityUpdatedEnglishTranslation);

            Translation cityDeletedEnglishTranslation = new Translation();
            cityDeletedEnglishTranslation.setLanguage(english);
            var cityDeletedEnglish = this.wordDao.getWordsByKey("city.deleted");
            cityDeletedEnglishTranslation.setWord(cityDeletedEnglish);
            cityDeletedEnglishTranslation.setTranslation("City Deleted");
            this.translationDao.save(cityDeletedEnglishTranslation);

            Translation citiesListedEnglishTranslation = new Translation();
            citiesListedEnglishTranslation.setLanguage(english);
            var citiesListedEnglish = this.wordDao.getWordsByKey("cities.listed");
            citiesListedEnglishTranslation.setWord(citiesListedEnglish);
            citiesListedEnglishTranslation.setTranslation("Cities Listed");
            this.translationDao.save(citiesListedEnglishTranslation);

            Translation cityFoundEnglishTranslation = new Translation();
            cityFoundEnglishTranslation.setLanguage(english);
            var cityFoundEnglish = this.wordDao.getWordsByKey("city.found");
            cityFoundEnglishTranslation.setWord(cityFoundEnglish);
            cityFoundEnglishTranslation.setTranslation("City Found");
            this.translationDao.save(cityFoundEnglishTranslation);

            Translation cityNotFoundEnglishTranslation = new Translation();
            cityNotFoundEnglishTranslation.setLanguage(english);
            var cityNotFoundEnglish = this.wordDao.getWordsByKey("city.not.found");
            cityNotFoundEnglishTranslation.setWord(cityNotFoundEnglish);
            cityNotFoundEnglishTranslation.setTranslation("City Not Found");
            this.translationDao.save(cityNotFoundEnglishTranslation);

            Translation cityExistsEnglishTranslation = new Translation();
            cityExistsEnglishTranslation.setLanguage(english);
            var cityExistsEnglish = this.wordDao.getWordsByKey("city.exists");
            cityExistsEnglishTranslation.setWord(cityExistsEnglish);
            cityExistsEnglishTranslation.setTranslation("City Exists");
            this.translationDao.save(cityExistsEnglishTranslation);

            //--------------------Rental------------------------------

            Translation rentalAddedEnglishTranslation = new Translation();
            rentalAddedEnglishTranslation.setLanguage(english);
            var rentalAddedEnglish = this.wordDao.getWordsByKey("rental.added");
            rentalAddedEnglishTranslation.setWord(rentalAddedEnglish);
            rentalAddedEnglishTranslation.setTranslation("Rental Added");
            this.translationDao.save(rentalAddedEnglishTranslation);

            Translation rentalUpdatedEnglishTranslation = new Translation();
            rentalUpdatedEnglishTranslation.setLanguage(english);
            var rentalUpdatedEnglish = this.wordDao.getWordsByKey("rental.updated");
            rentalUpdatedEnglishTranslation.setWord(rentalUpdatedEnglish);
            rentalUpdatedEnglishTranslation.setTranslation("Rental Updated");
            this.translationDao.save(rentalUpdatedEnglishTranslation);


            Translation rentalDeletedEnglishTranslation = new Translation();
            rentalDeletedEnglishTranslation.setLanguage(english);
            var rentalDeletedEnglish = this.wordDao.getWordsByKey("rental.deleted");
            rentalDeletedEnglishTranslation.setWord(rentalDeletedEnglish);
            rentalDeletedEnglishTranslation.setTranslation("Rental Deleted");
            this.translationDao.save(rentalDeletedEnglishTranslation);

            Translation rentalsListedEnglishTranslation = new Translation();
            rentalsListedEnglishTranslation.setLanguage(english);
            var rentalsListedEnglish = this.wordDao.getWordsByKey("rentals.listed");
            rentalsListedEnglishTranslation.setWord(rentalsListedEnglish);
            rentalsListedEnglishTranslation.setTranslation("Rentals Listed");
            this.translationDao.save(rentalsListedEnglishTranslation);

            Translation rentalFoundEnglishTranslation = new Translation();
            rentalFoundEnglishTranslation.setLanguage(english);
            var rentalFoundEnglish = this.wordDao.getWordsByKey("rental.found");
            rentalFoundEnglishTranslation.setWord(rentalFoundEnglish);
            rentalFoundEnglishTranslation.setTranslation("Rental Found");
            this.translationDao.save(rentalFoundEnglishTranslation);

            Translation rentalExistsEnglishTranslation = new Translation();
            rentalExistsEnglishTranslation.setLanguage(english);
            var rentalExistsEnglish = this.wordDao.getWordsByKey("rental.car.is.not.returned.yet");
            rentalExistsEnglishTranslation.setWord(rentalExistsEnglish);
            rentalExistsEnglishTranslation.setTranslation("Car Is Still Rented And Not Returned");
            this.translationDao.save(rentalExistsEnglishTranslation);


            Translation rentalNotFoundEnglishTranslation = new Translation();
            rentalNotFoundEnglishTranslation.setLanguage(english);
            var rentalNotFoundEnglish = this.wordDao.getWordsByKey("rental.not.found");
            rentalNotFoundEnglishTranslation.setWord(rentalNotFoundEnglish);
            rentalNotFoundEnglishTranslation.setTranslation("Rent Information Not Found");

            this.translationDao.save(rentalNotFoundEnglishTranslation);

            Translation rentedCarIsOnManitenanceEnglishTranslation = new Translation();
            rentedCarIsOnManitenanceEnglishTranslation.setLanguage(english);
            var rentedCarIsOnManitenanceEnglish = this.wordDao.getWordsByKey("rented.car.is.on.maintenance");
            rentedCarIsOnManitenanceEnglishTranslation.setWord(rentedCarIsOnManitenanceEnglish);
            rentedCarIsOnManitenanceEnglishTranslation.setTranslation("Rented Car Is On Maintenance");
            this.translationDao.save(rentedCarIsOnManitenanceEnglishTranslation);

            Translation rentalFindexScoreErrorEnglishTranslation = new Translation();
            rentalFindexScoreErrorEnglishTranslation.setLanguage(english);
            var rentalFindexScoreErrorEnglish = this.wordDao.getWordsByKey("rental.findex.score.error");
            rentalFindexScoreErrorEnglishTranslation.setWord(rentalFindexScoreErrorEnglish);
            rentalFindexScoreErrorEnglishTranslation.setTranslation("Your Findex Score Is Not Enough To Rent This Car");

            /*
            Translation rentalCarIsNotReturnedYetEnglishTranslation = new Translation();
            rentalCarIsNotReturnedYetEnglishTranslation.setLanguage(english);
            var rentalCarIsNotReturnedYetEnglish = this.wordDao.getWordsByKey("rental.car.is.not.returned.yet");
            rentalCarIsNotReturnedYetEnglishTranslation.setWord(rentalCarIsNotReturnedYetEnglish);
            rentalCarIsNotReturnedYetEnglishTranslation.setTranslation("Rented Car Has Not Returned Yet");
            this.translationDao.save(rentalCarIsNotReturnedYetEnglishTranslation);
*/

            Translation rentalDateErrorEnglishTranslation = new Translation();
            rentalDateErrorEnglishTranslation.setLanguage(english);
            var rentalDateErrorEnglish = this.wordDao.getWordsByKey("rental.date.error");
            rentalDateErrorEnglishTranslation.setWord(rentalDateErrorEnglish);
            rentalDateErrorEnglishTranslation.setTranslation("Rental's Rent Date Must Be Before Rental's Return Date");
            this.translationDao.save(rentalDateErrorEnglishTranslation);


            Translation carImageAddedEnglishTranslation = new Translation();
            carImageAddedEnglishTranslation.setLanguage(english);
            var carImageAddedEnglish = this.wordDao.getWordsByKey("car.image.added");
            carImageAddedEnglishTranslation.setWord(carImageAddedEnglish);
            carImageAddedEnglishTranslation.setTranslation("Car Image Added.");
            this.translationDao.save(carImageAddedEnglishTranslation);

            Translation carImageDeletedEnglishTranslation = new Translation();
            carImageDeletedEnglishTranslation.setLanguage(english);
            var carImageDeletedEnglish = this.wordDao.getWordsByKey("car.image.deleted");
            carImageDeletedEnglishTranslation.setWord(carImageDeletedEnglish);
            carImageDeletedEnglishTranslation.setTranslation("Car Image Deleted.");
            this.translationDao.save(carImageDeletedEnglishTranslation);

            Translation carImageUpdatedEnglishTranslation = new Translation();
            carImageUpdatedEnglishTranslation.setLanguage(english);
            var carImageUpdatedEnglish = this.wordDao.getWordsByKey("car.image.updated");
            carImageUpdatedEnglishTranslation.setWord(carImageUpdatedEnglish);
            carImageUpdatedEnglishTranslation.setTranslation("Car Image Updated.");
            this.translationDao.save(carImageUpdatedEnglishTranslation);

            Translation carImageListedEnglishTranslation = new Translation();
            carImageListedEnglishTranslation.setLanguage(english);
            var carImageListedEnglish = this.wordDao.getWordsByKey("car.images.listed");
            carImageListedEnglishTranslation.setWord(carImageListedEnglish);
            carImageListedEnglishTranslation.setTranslation("Car Images Are Listed.");
            this.translationDao.save(carImageListedEnglishTranslation);


            Translation carImageNameErrorEnglishTranslation = new Translation();
            carImageNameErrorEnglishTranslation.setLanguage(english);
            var carImageNameErrorEnglish = this.wordDao.getWordsByKey("car.image.type.error");
            carImageNameErrorEnglishTranslation.setWord(carImageNameErrorEnglish);
            carImageNameErrorEnglishTranslation.setTranslation("Car Image Type Error.");
            this.translationDao.save(carImageNameErrorEnglishTranslation);

            Translation carImageNotFoundEnglishTranslation = new Translation();
            carImageNotFoundEnglishTranslation.setLanguage(english);
            var carImageNotFoundEnglish = this.wordDao.getWordsByKey("car.image.not.found");
            carImageNotFoundEnglishTranslation.setWord(carImageNotFoundEnglish);
            carImageNotFoundEnglishTranslation.setTranslation("Car Image Not Found.");
            this.translationDao.save(carImageNotFoundEnglishTranslation);


            Translation creditCardAddedEnglishTranslation = new Translation();
            creditCardAddedEnglishTranslation.setLanguage(english);
            var creditCardAddedEnglish = this.wordDao.getWordsByKey("credit.card.added");
            creditCardAddedEnglishTranslation.setWord(creditCardAddedEnglish);
            creditCardAddedEnglishTranslation.setTranslation("Credit Card Added.");
            this.translationDao.save(creditCardAddedEnglishTranslation);

            Translation creditCardDeletedEnglishTranslation = new Translation();
            creditCardDeletedEnglishTranslation.setLanguage(english);
            var creditCardDeletedEnglish = this.wordDao.getWordsByKey("credit.card.deleted");
            creditCardDeletedEnglishTranslation.setWord(creditCardDeletedEnglish);
            creditCardDeletedEnglishTranslation.setTranslation("Credit Card Deleted.");
            this.translationDao.save(creditCardDeletedEnglishTranslation);

            Translation creditCardUpdatedEnglishTranslation = new Translation();
            creditCardUpdatedEnglishTranslation.setLanguage(english);
            var creditCardUpdatedEnglish = this.wordDao.getWordsByKey("credit.card.updated");
            creditCardUpdatedEnglishTranslation.setWord(creditCardUpdatedEnglish);
            creditCardUpdatedEnglishTranslation.setTranslation("Credit Card Updated.");
            this.translationDao.save(creditCardUpdatedEnglishTranslation);

            Translation creditCardListedEnglishTranslation = new Translation();
            creditCardListedEnglishTranslation.setLanguage(english);
            var creditCardListedEnglish = this.wordDao.getWordsByKey("credit.cards.listed");
            creditCardListedEnglishTranslation.setWord(creditCardListedEnglish);
            creditCardListedEnglishTranslation.setTranslation("Credit Cards Listed.");
            this.translationDao.save(creditCardListedEnglishTranslation);


            Translation creditCardNameErrorEnglishTranslation = new Translation();
            creditCardNameErrorEnglishTranslation.setLanguage(english);
            var creditCardNameErrorEnglish = this.wordDao.getWordsByKey("credit.card.name.error");
            creditCardNameErrorEnglishTranslation.setWord(creditCardNameErrorEnglish);
            creditCardNameErrorEnglishTranslation.setTranslation("Credit Card Name Error.");
            this.translationDao.save(creditCardNameErrorEnglishTranslation);

            Translation creditCardNotFoundEnglishTranslation = new Translation();
            creditCardNotFoundEnglishTranslation.setLanguage(english);
            var creditCardNotFoundEnglish = this.wordDao.getWordsByKey("credit.card.not.found");
            creditCardNotFoundEnglishTranslation.setWord(creditCardNotFoundEnglish);
            creditCardNotFoundEnglishTranslation.setTranslation("Credit Card Not Found.");
            this.translationDao.save(creditCardNotFoundEnglishTranslation);

            Translation invoiceAddedEnglishTranslation = new Translation();
            invoiceAddedEnglishTranslation.setLanguage(english);
            var invoiceAddedEnglish = this.wordDao.getWordsByKey("invoice.added");
            invoiceAddedEnglishTranslation.setWord(invoiceAddedEnglish);
            invoiceAddedEnglishTranslation.setTranslation("Invoice Added.");
            this.translationDao.save(invoiceAddedEnglishTranslation);

            Translation invoiceDeletedEnglishTranslation = new Translation();
            invoiceDeletedEnglishTranslation.setLanguage(english);
            var invoiceDeletedEnglish = this.wordDao.getWordsByKey("invoice.deleted");
            invoiceDeletedEnglishTranslation.setWord(invoiceDeletedEnglish);
            invoiceDeletedEnglishTranslation.setTranslation("Invoice Deleted.");
            this.translationDao.save(invoiceDeletedEnglishTranslation);

            Translation invoiceUpdatedEnglishTranslation = new Translation();
            invoiceUpdatedEnglishTranslation.setLanguage(english);
            var invoiceUpdatedEnglish = this.wordDao.getWordsByKey("invoice.updated");
            invoiceUpdatedEnglishTranslation.setWord(invoiceUpdatedEnglish);
            invoiceUpdatedEnglishTranslation.setTranslation("Invoice Updated.");
            this.translationDao.save(invoiceUpdatedEnglishTranslation);

            Translation invoiceListedEnglishTranslation = new Translation();
            invoiceListedEnglishTranslation.setLanguage(english);
            var invoiceListedEnglish = this.wordDao.getWordsByKey("invoices.listed");
            invoiceListedEnglishTranslation.setWord(invoiceListedEnglish);
            invoiceListedEnglishTranslation.setTranslation("Invoice Listed");
            this.translationDao.save(invoiceListedEnglishTranslation);



            Translation invoiceNotFoundEnglishTranslation = new Translation();
            invoiceNotFoundEnglishTranslation.setLanguage(english);
            var invoiceNotFoundEnglish = this.wordDao.getWordsByKey("invoice.not.found");
            invoiceNotFoundEnglishTranslation.setWord(invoiceNotFoundEnglish);
            invoiceNotFoundEnglishTranslation.setTranslation("Invoice Not Found.");
            this.translationDao.save(invoiceNotFoundEnglishTranslation);

            Translation additionalServiceAddedEnglishTranslation = new Translation();
            additionalServiceAddedEnglishTranslation.setLanguage(english);
            var additionalServiceAddedEnglish = this.wordDao.getWordsByKey("additional.service.added");
            additionalServiceAddedEnglishTranslation.setWord(additionalServiceAddedEnglish);
            additionalServiceAddedEnglishTranslation.setTranslation("Additional Service Added.");
            this.translationDao.save(additionalServiceAddedEnglishTranslation);

            Translation additionalServiceDeletedEnglishTranslation = new Translation();
            additionalServiceDeletedEnglishTranslation.setLanguage(english);
            var additionalServiceDeletedEnglish = this.wordDao.getWordsByKey("additional.service.deleted");
            additionalServiceDeletedEnglishTranslation.setWord(additionalServiceDeletedEnglish);
            additionalServiceDeletedEnglishTranslation.setTranslation("Additional Service Deleted.");
            this.translationDao.save(additionalServiceDeletedEnglishTranslation);

            Translation additionalServiceUpdatedEnglishTranslation = new Translation();
            additionalServiceUpdatedEnglishTranslation.setLanguage(english);
            var additionalServiceUpdatedEnglish = this.wordDao.getWordsByKey("additional.service.updated");
            additionalServiceUpdatedEnglishTranslation.setWord(additionalServiceUpdatedEnglish);
            additionalServiceUpdatedEnglishTranslation.setTranslation("Additional Service Updated.");
            this.translationDao.save(additionalServiceUpdatedEnglishTranslation);

            Translation additionalServiceListedEnglishTranslation = new Translation();
            additionalServiceListedEnglishTranslation.setLanguage(english);
            var additionalServiceListedEnglish = this.wordDao.getWordsByKey("additional.services.listed");
            additionalServiceListedEnglishTranslation.setWord(additionalServiceListedEnglish);
            additionalServiceListedEnglishTranslation.setTranslation("Additional Service Listed.");
            this.translationDao.save(additionalServiceListedEnglishTranslation);


            Translation additionalServiceNotFoundEnglishTranslation = new Translation();
            additionalServiceNotFoundEnglishTranslation.setLanguage(english);
            var additionalServiceNotFoundEnglish = this.wordDao.getWordsByKey("additional.service.not.found");
            additionalServiceNotFoundEnglishTranslation.setWord(additionalServiceNotFoundEnglish);
            additionalServiceNotFoundEnglishTranslation.setTranslation("Additional Service Not Found.");
            this.translationDao.save(additionalServiceNotFoundEnglishTranslation);


            Translation userNotFoundEnglishTranslation = new Translation();
            userNotFoundEnglishTranslation.setLanguage(english);
            var userNotFoundEnglish = this.wordDao.getWordsByKey("user.not.found");
            userNotFoundEnglishTranslation.setWord(userNotFoundEnglish);
            userNotFoundEnglishTranslation.setTranslation("User Not Found.");
            this.translationDao.save(userNotFoundEnglishTranslation);

            Translation customerAddedEnglishTranslation = new Translation();
            customerAddedEnglishTranslation.setLanguage(english);
            var customerAddedEnglish = this.wordDao.getWordsByKey("customer.added");
            customerAddedEnglishTranslation.setWord(customerAddedEnglish);
            customerAddedEnglishTranslation.setTranslation("Customer Added");
            this.translationDao.save(customerAddedEnglishTranslation);

            Translation customerUpdatedEnglishTranslation = new Translation();
            customerUpdatedEnglishTranslation.setLanguage(english);
            var customerUpdatedEnglish = this.wordDao.getWordsByKey("customer.updated");
            customerUpdatedEnglishTranslation.setWord(customerUpdatedEnglish);
            customerUpdatedEnglishTranslation.setTranslation("Customer Updated");
            this.translationDao.save(customerUpdatedEnglishTranslation);

            Translation customerDeletedEnglishTranslation = new Translation();
            customerDeletedEnglishTranslation.setLanguage(english);
            var customerDeletedEnglish = this.wordDao.getWordsByKey("customer.deleted");
            customerDeletedEnglishTranslation.setWord(customerDeletedEnglish);
            customerDeletedEnglishTranslation.setTranslation("Customer Deleted");
            this.translationDao.save(customerDeletedEnglishTranslation);

            Translation customersFoundEnglishTranslation = new Translation();
            customersFoundEnglishTranslation.setLanguage(english);
            var customersFoundEnglish = this.wordDao.getWordsByKey("customers.listed");
            customersFoundEnglishTranslation.setWord(customersFoundEnglish);
            customersFoundEnglishTranslation.setTranslation("Customers Listed");
            this.translationDao.save(customersFoundEnglishTranslation);

            Translation customerFoundEnglishTranslation = new Translation();
            customerFoundEnglishTranslation.setLanguage(english);
            var customerFoundEnglish = this.wordDao.getWordsByKey("customer.found");
            customerFoundEnglishTranslation.setWord(customerFoundEnglish);
            customerFoundEnglishTranslation.setTranslation("Customers Found");
            this.translationDao.save(customerFoundEnglishTranslation);

            Translation customerNotFoundEnglishTranslation = new Translation();
            customerNotFoundEnglishTranslation.setLanguage(english);
            var customerNotFoundEnglish = this.wordDao.getWordsByKey("customer.not.found");
            customerNotFoundEnglishTranslation.setWord(customerNotFoundEnglish);
            customerNotFoundEnglishTranslation.setTranslation("Customer Not Found");
            this.translationDao.save(customerNotFoundEnglishTranslation);

            Translation customerAlreadyExistsEnglishTranslation = new Translation();
            customerAlreadyExistsEnglishTranslation.setLanguage(english);
            var customerAlreadyExistsEnglish = this.wordDao.getWordsByKey("customer.already.exists");
            customerAlreadyExistsEnglishTranslation.setWord(customerAlreadyExistsEnglish);
            customerAlreadyExistsEnglishTranslation.setTranslation("Customer Already Exists");
            this.translationDao.save(customerAlreadyExistsEnglishTranslation);

            Translation customerNationalIdentityAlreadyExistsEnglishTranslation = new Translation();
            customerNationalIdentityAlreadyExistsEnglishTranslation.setLanguage(english);
            var customerNationalIdentityAlreadyExistsEnglish = this.wordDao.getWordsByKey("customer.national.identity.already.exists");
            customerNationalIdentityAlreadyExistsEnglishTranslation.setWord(customerNationalIdentityAlreadyExistsEnglish);
            customerNationalIdentityAlreadyExistsEnglishTranslation.setTranslation("Customer National Identity Already Exists");
            this.translationDao.save(customerNationalIdentityAlreadyExistsEnglishTranslation);

            Translation customerTaxNumberAlreadyExistsEnglishTranslation = new Translation();
            customerTaxNumberAlreadyExistsEnglishTranslation.setLanguage(english);
            var customerTaxNumberAlreadyExistsEnglish = this.wordDao.getWordsByKey("customers.tax.number.already.exists");
            customerTaxNumberAlreadyExistsEnglishTranslation.setWord(customerTaxNumberAlreadyExistsEnglish);
            customerTaxNumberAlreadyExistsEnglishTranslation.setTranslation("Customer Tax Number Already Exists");
            this.translationDao.save(customerTaxNumberAlreadyExistsEnglishTranslation);


            var turkish = languageDao.getLanguagesByName("Turkish");
            if (turkish == null){
                turkish = languageDao.getLanguagesByName("English");
            }

            Translation customerAddedTurkishTranslation = new Translation();
            customerAddedTurkishTranslation.setLanguage(turkish);
            var customerAddedTurkish = this.wordDao.getWordsByKey("customer.added");
            customerAddedTurkishTranslation.setWord(customerAddedTurkish);
            customerAddedTurkishTranslation.setTranslation("Müşteri Eklendi.");
            this.translationDao.save(customerAddedTurkishTranslation);

            Translation customerDeletedTurkishTranslation = new Translation();
            customerDeletedTurkishTranslation.setLanguage(turkish);
            var customerDeletedTurkish = this.wordDao.getWordsByKey("customer.deleted");
            customerDeletedTurkishTranslation.setWord(customerDeletedTurkish);
            customerDeletedTurkishTranslation.setTranslation("Müşteri Silindi.");
            this.translationDao.save(customerDeletedTurkishTranslation);

            Translation customerUpdatedTurkishTranslation = new Translation();
            customerUpdatedTurkishTranslation.setLanguage(turkish);
            var customerUpdatedTurkish = this.wordDao.getWordsByKey("customer.updated");
            customerUpdatedTurkishTranslation.setWord(customerUpdatedTurkish);
            customerUpdatedTurkishTranslation.setTranslation("Müşteri güncellendi.");
            this.translationDao.save(customerUpdatedTurkishTranslation);

            Translation customerFoundTurkishTranslation = new Translation();
            customerFoundTurkishTranslation.setLanguage(turkish);
            var customerFoundTurkish = this.wordDao.getWordsByKey("customer.found");
            customerFoundTurkishTranslation.setWord(customerFoundTurkish);
            customerFoundTurkishTranslation.setTranslation("Müşteri bulundu.");
            this.translationDao.save(customerFoundTurkishTranslation);

            Translation customerNotFoundTurkishTranslation = new Translation();
            customerNotFoundTurkishTranslation.setLanguage(turkish);
            var customerNotFoundTurkish = this.wordDao.getWordsByKey("customer.not.found");
            customerNotFoundTurkishTranslation.setWord(customerNotFoundTurkish);
            customerNotFoundTurkishTranslation.setTranslation("Müşteri Bulunamadı");
            this.translationDao.save(customerNotFoundTurkishTranslation);

            Translation customerAlreadyExistsTurkishTranslation = new Translation();
            customerAlreadyExistsTurkishTranslation.setLanguage(turkish);
            var customerAlreadyExistsTurkish = this.wordDao.getWordsByKey("customer.already.exists");
            customerAlreadyExistsTurkishTranslation.setWord(customerAlreadyExistsTurkish);
            customerAlreadyExistsTurkishTranslation.setTranslation("Müşteri Zaten Kayıtlı");
            this.translationDao.save(customerAlreadyExistsTurkishTranslation);

            Translation customersTaxNumberAlreadyExistsTurkishTranslation = new Translation();
            customersTaxNumberAlreadyExistsTurkishTranslation.setLanguage(turkish);
            var customersTaxNumberAlreadyExistsTurkish = this.wordDao.getWordsByKey("customers.tax.number.already.exists");
            customersTaxNumberAlreadyExistsTurkishTranslation.setWord(customersTaxNumberAlreadyExistsTurkish);
            customersTaxNumberAlreadyExistsTurkishTranslation.setTranslation("Müşterinin vergi numarası zaten kayıtlı.");
            this.translationDao.save(customersTaxNumberAlreadyExistsTurkishTranslation);

            Translation brandAddedTurkishTranslation = new Translation();
            brandAddedTurkishTranslation.setLanguage(turkish);
            var brandAddedTurkish = this.wordDao.getWordsByKey("brand.added");
            brandAddedTurkishTranslation.setWord(brandAddedTurkish);
            brandAddedTurkishTranslation.setTranslation("Marka eklendi.");
            this.translationDao.save(brandAddedTurkishTranslation);

            Translation brandDeletedTurkishTranslation = new Translation();
            brandDeletedTurkishTranslation.setLanguage(turkish);
            var brandDeletedTurkish = this.wordDao.getWordsByKey("brand.deleted");
            brandDeletedTurkishTranslation.setWord(brandDeletedTurkish);
            brandDeletedTurkishTranslation.setTranslation("Marka silindi.");
            this.translationDao.save(brandDeletedTurkishTranslation);

            Translation brandUpdatedTurkishTranslation = new Translation();
            brandUpdatedTurkishTranslation.setLanguage(turkish);
            var brandUpdatedTurkish = this.wordDao.getWordsByKey("brand.updated");
            brandUpdatedTurkishTranslation.setWord(brandUpdatedTurkish);
            brandUpdatedTurkishTranslation.setTranslation("Marka güncellendi.");
            this.translationDao.save(brandUpdatedTurkishTranslation);

            Translation brandListedTurkishTranslation = new Translation();
            brandListedTurkishTranslation.setLanguage(turkish);
            var brandListedTurkish = this.wordDao.getWordsByKey("brands.listed");
            brandListedTurkishTranslation.setWord(brandListedTurkish);
            brandListedTurkishTranslation.setTranslation("Marka listelendi.");
            this.translationDao.save(brandListedTurkishTranslation);

            Translation brandNotFoundTurkishTranslation = new Translation();
            brandNotFoundTurkishTranslation.setLanguage(turkish);
            var brandNotFoundTurkish = this.wordDao.getWordsByKey("brand.not.found");
            brandNotFoundTurkishTranslation.setWord(brandNotFoundTurkish);
            brandNotFoundTurkishTranslation.setTranslation("Marka bulunamadı.");
            this.translationDao.save(brandNotFoundTurkishTranslation);

            Translation brandFoundTurkishTranslation = new Translation();
            brandFoundTurkishTranslation.setLanguage(turkish);
            var brandFoundTurkish = this.wordDao.getWordsByKey("brand.found");
            brandFoundTurkishTranslation.setWord(brandFoundTurkish);
            brandFoundTurkishTranslation.setTranslation("Marka bulundu.");
            this.translationDao.save(brandFoundTurkishTranslation);

            Translation brandExistsTurkishTranslation = new Translation();
            brandExistsTurkishTranslation.setLanguage(turkish);
            var brandExistsTurkish = this.wordDao.getWordsByKey("brand.exists");
            brandExistsTurkishTranslation.setWord(brandExistsTurkish);
            brandExistsTurkishTranslation.setTranslation("Marka zaten kayıtlı.");
            this.translationDao.save(brandExistsTurkishTranslation);

            Translation colorAddedTurkishTranslation = new Translation();
            colorAddedTurkishTranslation.setLanguage(turkish);
            var colorAddedTurkish = this.wordDao.getWordsByKey("color.added");
            colorAddedTurkishTranslation.setWord(colorAddedTurkish);
            colorAddedTurkishTranslation.setTranslation("Renk eklendi.");
            this.translationDao.save(colorAddedTurkishTranslation);

            Translation colorDeletedTurkishTranslation = new Translation();
            colorDeletedTurkishTranslation.setLanguage(turkish);
            var colorDeletedTurkish = this.wordDao.getWordsByKey("color.deleted");
            colorDeletedTurkishTranslation.setWord(colorDeletedTurkish);
            colorDeletedTurkishTranslation.setTranslation("Renk silindi.");
            this.translationDao.save(colorDeletedTurkishTranslation);

            Translation colorUpdatedTurkishTranslation = new Translation();
            colorUpdatedTurkishTranslation.setLanguage(turkish);
            var colorUpdatedTurkish = this.wordDao.getWordsByKey("color.updated");
            colorUpdatedTurkishTranslation.setWord(colorUpdatedTurkish);
            colorUpdatedTurkishTranslation.setTranslation("Renk güncellendi.");
            this.translationDao.save(colorUpdatedTurkishTranslation);

            Translation colorListedTurkishTranslation = new Translation();
            colorListedTurkishTranslation.setLanguage(turkish);
            var colorListedTurkish = this.wordDao.getWordsByKey("colors.listed");
            colorListedTurkishTranslation.setWord(colorListedTurkish);
            colorListedTurkishTranslation.setTranslation("Renkler listelendi.");
            this.translationDao.save(colorListedTurkishTranslation);

            Translation colorAlreadyExistsTurkishTranslation = new Translation();
            colorAlreadyExistsTurkishTranslation.setLanguage(turkish);
            var colorAlreadyExistsTurkish = this.wordDao.getWordsByKey("color.already.exists");
            colorAlreadyExistsTurkishTranslation.setWord(colorAlreadyExistsTurkish);
            colorAlreadyExistsTurkishTranslation.setTranslation("Renk zaten mevcut.");
            this.translationDao.save(colorAlreadyExistsTurkishTranslation);

            Translation colorFoundTurkishTranslation = new Translation();
            colorFoundTurkishTranslation.setLanguage(turkish);
            var colorFoundTurkish = this.wordDao.getWordsByKey("color.found");
            colorFoundTurkishTranslation.setWord(colorFoundTurkish);
            colorFoundTurkishTranslation.setTranslation("Renk bulundu.");
            this.translationDao.save(colorFoundTurkishTranslation);

            Translation colorNotFoundTurkishTranslation = new Translation();
            colorNotFoundTurkishTranslation.setLanguage(turkish);
            var colorNotFoundTurkish = this.wordDao.getWordsByKey("color.not.found");
            colorNotFoundTurkishTranslation.setWord(colorNotFoundTurkish);
            colorNotFoundTurkishTranslation.setTranslation("Renk bulunamadı.");
            this.translationDao.save(colorNotFoundTurkishTranslation);

            Translation carImageAddedTurkishTranslation = new Translation();
            carImageAddedTurkishTranslation.setLanguage(turkish);
            var carImageAddedTurkish = this.wordDao.getWordsByKey("car.image.added");
            carImageAddedTurkishTranslation.setWord(carImageAddedTurkish);
            carImageAddedTurkishTranslation.setTranslation("Araç görseli eklendi.");
            this.translationDao.save(carImageAddedTurkishTranslation);

            Translation carImageDeletedTurkishTranslation = new Translation();
            carImageDeletedTurkishTranslation.setLanguage(turkish);
            var carImageDeletedTurkish = this.wordDao.getWordsByKey("car.image.deleted");
            carImageDeletedTurkishTranslation.setWord(carImageDeletedTurkish);
            carImageDeletedTurkishTranslation.setTranslation("Araç görseli silindi.");
            this.translationDao.save(carImageDeletedTurkishTranslation);

            Translation carImageUpdatedTurkishTranslation = new Translation();
            carImageUpdatedTurkishTranslation.setLanguage(turkish);
            var carImageUpdatedTurkish = this.wordDao.getWordsByKey("car.image.updated");
            carImageUpdatedTurkishTranslation.setWord(carImageUpdatedTurkish);
            carImageUpdatedTurkishTranslation.setTranslation("Araç görseli güncellendi.");
            this.translationDao.save(carImageUpdatedTurkishTranslation);

            Translation carImageListedTurkishTranslation = new Translation();
            carImageListedTurkishTranslation.setLanguage(turkish);
            var carImageListedTurkish = this.wordDao.getWordsByKey("car.images.listed");
            carImageListedTurkishTranslation.setWord(carImageListedTurkish);
            carImageListedTurkishTranslation.setTranslation("Araç görselleri listelendi.");
            this.translationDao.save(carImageListedTurkishTranslation);


            Translation carImageNotFoundTurkishTranslation = new Translation();
            carImageNotFoundTurkishTranslation.setLanguage(turkish);
            var carImageNotFoundTurkish = this.wordDao.getWordsByKey("car.image.not.found");
            carImageNotFoundTurkishTranslation.setWord(carImageNotFoundTurkish);
            carImageNotFoundTurkishTranslation.setTranslation("Araç görseli bulunamadı.");
            this.translationDao.save(carImageNotFoundTurkishTranslation);

            Translation carAddedTurkishTranslation = new Translation();
            carAddedTurkishTranslation.setLanguage(turkish);
            var carAddedTurkish = this.wordDao.getWordsByKey("car.added");
            carAddedTurkishTranslation.setWord(carAddedTurkish);
            carAddedTurkishTranslation.setTranslation("Araç eklendi.");
            this.translationDao.save(carAddedTurkishTranslation);

            Translation carDeletedTurkishTranslation = new Translation();
            carDeletedTurkishTranslation.setLanguage(turkish);
            var carDeletedTurkish = this.wordDao.getWordsByKey("car.deleted");
            carDeletedTurkishTranslation.setWord(carDeletedTurkish);
            carDeletedTurkishTranslation.setTranslation("Araç silindi.");
            this.translationDao.save(carDeletedTurkishTranslation);

            Translation carUpdatedTurkishTranslation = new Translation();
            carUpdatedTurkishTranslation.setLanguage(turkish);
            var carUpdatedTurkish = this.wordDao.getWordsByKey("car.updated");
            carUpdatedTurkishTranslation.setWord(carUpdatedTurkish);
            carUpdatedTurkishTranslation.setTranslation("Araç güncellendi.");
            this.translationDao.save(carUpdatedTurkishTranslation);

            Translation carListedTurkishTranslation = new Translation();
            carListedTurkishTranslation.setLanguage(turkish);
            var carListedTurkish = this.wordDao.getWordsByKey("cars.listed");
            carListedTurkishTranslation.setWord(carListedTurkish);
            carListedTurkishTranslation.setTranslation("Araçlar listelendi.");
            this.translationDao.save(carListedTurkishTranslation);

            Translation carNotFoundTurkishTranslation = new Translation();
            carNotFoundTurkishTranslation.setLanguage(turkish);
            var carNotFoundTurkish = this.wordDao.getWordsByKey("car.not.found");
            carNotFoundTurkishTranslation.setWord(carNotFoundTurkish);
            carNotFoundTurkishTranslation.setTranslation("Araç bulunamadı.");
            this.translationDao.save(carNotFoundTurkishTranslation);

            Translation rentalAddedTurkishTranslation = new Translation();
            rentalAddedTurkishTranslation.setLanguage(turkish);
            var rentalAddedTurkish = this.wordDao.getWordsByKey("rental.added");
            rentalAddedTurkishTranslation.setWord(rentalAddedTurkish);
            rentalAddedTurkishTranslation.setTranslation("Kiralama eklendi.");
            this.translationDao.save(rentalAddedTurkishTranslation);

            Translation rentalDeletedTurkishTranslation = new Translation();
            rentalDeletedTurkishTranslation.setLanguage(turkish);
            var rentalDeletedTurkish = this.wordDao.getWordsByKey("rental.deleted");
            rentalDeletedTurkishTranslation.setWord(rentalDeletedTurkish);
            rentalDeletedTurkishTranslation.setTranslation("Kiralama silindi.");
            this.translationDao.save(rentalDeletedTurkishTranslation);

            Translation rentalUpdatedTurkishTranslation = new Translation();
            rentalUpdatedTurkishTranslation.setLanguage(turkish);
            var rentalUpdatedTurkish = this.wordDao.getWordsByKey("rental.updated");
            rentalUpdatedTurkishTranslation.setWord(rentalUpdatedTurkish);
            rentalUpdatedTurkishTranslation.setTranslation("Kiralama güncellendi.");
            this.translationDao.save(rentalUpdatedTurkishTranslation);

            Translation rentalListedTurkishTranslation = new Translation();
            rentalListedTurkishTranslation.setLanguage(turkish);
            var rentalListedTurkish = this.wordDao.getWordsByKey("rentals.listed");
            rentalListedTurkishTranslation.setWord(rentalListedTurkish);
            rentalListedTurkishTranslation.setTranslation("Kiralama listelendi.");
            this.translationDao.save(rentalListedTurkishTranslation);

            Translation rentalNotFoundTurkishTranslation = new Translation();
            rentalNotFoundTurkishTranslation.setLanguage(turkish);
            var rentalNotFoundTurkish = this.wordDao.getWordsByKey("rental.not.found");
            rentalNotFoundTurkishTranslation.setWord(rentalNotFoundTurkish);
            rentalNotFoundTurkishTranslation.setTranslation("Kiralama bulunamadı.");
            this.translationDao.save(rentalNotFoundTurkishTranslation);

            Translation creditCardAddedTurkishTranslation = new Translation();
            creditCardAddedTurkishTranslation.setLanguage(turkish);
            var creditCardAddedTurkish = this.wordDao.getWordsByKey("credit.card.added");
            creditCardAddedTurkishTranslation.setWord(creditCardAddedTurkish);
            creditCardAddedTurkishTranslation.setTranslation("Kredi kartı eklendi.");
            this.translationDao.save(creditCardAddedTurkishTranslation);

            Translation creditCardDeletedTurkishTranslation = new Translation();
            creditCardDeletedTurkishTranslation.setLanguage(turkish);
            var creditCardDeletedTurkish = this.wordDao.getWordsByKey("credit.card.deleted");
            creditCardDeletedTurkishTranslation.setWord(creditCardDeletedTurkish);
            creditCardDeletedTurkishTranslation.setTranslation("Kredi kartı silindi.");
            this.translationDao.save(creditCardDeletedTurkishTranslation);

            Translation creditCardUpdatedTurkishTranslation = new Translation();
            creditCardUpdatedTurkishTranslation.setLanguage(turkish);
            var creditCardUpdatedTurkish = this.wordDao.getWordsByKey("credit.card.updated");
            creditCardUpdatedTurkishTranslation.setWord(creditCardUpdatedTurkish);
            creditCardUpdatedTurkishTranslation.setTranslation("Kredi kartı güncellendi.");
            this.translationDao.save(creditCardUpdatedTurkishTranslation);

            Translation creditCardListedTurkishTranslation = new Translation();
            creditCardListedTurkishTranslation.setLanguage(turkish);
            var creditCardListedTurkish = this.wordDao.getWordsByKey("credit.cards.listed");
            creditCardListedTurkishTranslation.setWord(creditCardListedTurkish);
            creditCardListedTurkishTranslation.setTranslation("Kredi kartları listelendi.");
            this.translationDao.save(creditCardListedTurkishTranslation);


            Translation creditCardNameErrorTurkishTranslation = new Translation();
            creditCardNameErrorTurkishTranslation.setLanguage(turkish);
            var creditCardNameErrorTurkish = this.wordDao.getWordsByKey("credit.card.name.error");
            creditCardNameErrorTurkishTranslation.setWord(creditCardNameErrorTurkish);
            creditCardNameErrorTurkishTranslation.setTranslation("Kredi kartı ismi hatalı.");
            this.translationDao.save(creditCardNameErrorTurkishTranslation);

            Translation creditCardNotFoundTurkishTranslation = new Translation();
            creditCardNotFoundTurkishTranslation.setLanguage(turkish);
            var creditCardNotFoundTurkish = this.wordDao.getWordsByKey("credit.card.not.found");
            creditCardNotFoundTurkishTranslation.setWord(creditCardNotFoundTurkish);
            creditCardNotFoundTurkishTranslation.setTranslation("Kredi kartı bulunamadı.");
            this.translationDao.save(creditCardNotFoundTurkishTranslation);

            Translation invoiceAddedTurkishTranslation = new Translation();
            invoiceAddedTurkishTranslation.setLanguage(turkish);
            var invoiceAddedTurkish = this.wordDao.getWordsByKey("invoice.added");
            invoiceAddedTurkishTranslation.setWord(invoiceAddedTurkish);
            invoiceAddedTurkishTranslation.setTranslation("Fatura eklendi.");
            this.translationDao.save(invoiceAddedTurkishTranslation);

            Translation invoiceDeletedTurkishTranslation = new Translation();
            invoiceDeletedTurkishTranslation.setLanguage(turkish);
            var invoiceDeletedTurkish = this.wordDao.getWordsByKey("invoice.deleted");
            invoiceDeletedTurkishTranslation.setWord(invoiceDeletedTurkish);
            invoiceDeletedTurkishTranslation.setTranslation("Fatura silindi.");
            this.translationDao.save(invoiceDeletedTurkishTranslation);

            Translation invoiceUpdatedTurkishTranslation = new Translation();
            invoiceUpdatedTurkishTranslation.setLanguage(turkish);
            var invoiceUpdatedTurkish = this.wordDao.getWordsByKey("invoice.updated");
            invoiceUpdatedTurkishTranslation.setWord(invoiceUpdatedTurkish);
            invoiceUpdatedTurkishTranslation.setTranslation("Fatura güncellendi.");
            this.translationDao.save(invoiceUpdatedTurkishTranslation);

            Translation invoiceListedTurkishTranslation = new Translation();
            invoiceListedTurkishTranslation.setLanguage(turkish);
            var invoiceListedTurkish = this.wordDao.getWordsByKey("invoices.listed");
            invoiceListedTurkishTranslation.setWord(invoiceListedTurkish);
            invoiceListedTurkishTranslation.setTranslation("Fatura listelendi.");
            this.translationDao.save(invoiceListedTurkishTranslation);

            Translation invoiceNotFoundTurkishTranslation = new Translation();
            invoiceNotFoundTurkishTranslation.setLanguage(turkish);
            var invoiceNotFoundTurkish = this.wordDao.getWordsByKey("invoice.not.found");
            invoiceNotFoundTurkishTranslation.setWord(invoiceNotFoundTurkish);
            invoiceNotFoundTurkishTranslation.setTranslation("Fatura bulunamadı.");
            this.translationDao.save(invoiceNotFoundTurkishTranslation);



            Translation additionalServiceAddedTurkishTranslation = new Translation();
            additionalServiceAddedTurkishTranslation.setLanguage(turkish);
            var additionalServiceAddedTurkish = this.wordDao.getWordsByKey("additional.service.added");
            additionalServiceAddedTurkishTranslation.setWord(additionalServiceAddedTurkish);
            additionalServiceAddedTurkishTranslation.setTranslation("Ek Hizmet eklendi.");
            this.translationDao.save(additionalServiceAddedTurkishTranslation);

            Translation additionalServiceDeletedTurkishTranslation = new Translation();
            additionalServiceDeletedTurkishTranslation.setLanguage(turkish);
            var additionalServiceDeletedTurkish = this.wordDao.getWordsByKey("additional.service.deleted");
            additionalServiceDeletedTurkishTranslation.setWord(additionalServiceDeletedTurkish);
            additionalServiceDeletedTurkishTranslation.setTranslation("Ek Hizmet silindi.");
            this.translationDao.save(additionalServiceDeletedTurkishTranslation);

            Translation additionalServiceUpdatedTurkishTranslation = new Translation();
            additionalServiceUpdatedTurkishTranslation.setLanguage(turkish);
            var additionalServiceUpdatedTurkish = this.wordDao.getWordsByKey("additional.service.updated");
            additionalServiceUpdatedTurkishTranslation.setWord(additionalServiceUpdatedTurkish);
            additionalServiceUpdatedTurkishTranslation.setTranslation("Ek Hizmet güncellendi.");
            this.translationDao.save(additionalServiceUpdatedTurkishTranslation);

            Translation additionalServiceListedTurkishTranslation = new Translation();
            additionalServiceListedTurkishTranslation.setLanguage(turkish);
            var additionalServiceListedTurkish = this.wordDao.getWordsByKey("additional.services.listed");
            additionalServiceListedTurkishTranslation.setWord(additionalServiceListedTurkish);
            additionalServiceListedTurkishTranslation.setTranslation("Ek Hizmet listelendi.");
            this.translationDao.save(additionalServiceListedTurkishTranslation);

            Translation additionalServiceNotFoundTurkishTranslation = new Translation();
            additionalServiceNotFoundTurkishTranslation.setLanguage(turkish);
            var additionalServiceNotFoundTurkish = this.wordDao.getWordsByKey("additional.service.not.found");
            additionalServiceNotFoundTurkishTranslation.setWord(additionalServiceNotFoundTurkish);
            additionalServiceNotFoundTurkishTranslation.setTranslation("Ek Hizmet bulunamadı.");
            this.translationDao.save(additionalServiceNotFoundTurkishTranslation);



            Translation userNameErrorTurkishTranslation = new Translation();
            userNameErrorTurkishTranslation.setLanguage(turkish);
            var userNameErrorTurkish = this.wordDao.getWordsByKey("user.email.already.exists");
            userNameErrorTurkishTranslation.setWord(userNameErrorTurkish);
            userNameErrorTurkishTranslation.setTranslation("Kullanıcı maili sistemde kayıtlı");
            this.translationDao.save(userNameErrorTurkishTranslation);

            Translation userNotFoundTurkishTranslation = new Translation();
            userNotFoundTurkishTranslation.setLanguage(turkish);
            var userNotFoundTurkish = this.wordDao.getWordsByKey("user.not.found");
            userNotFoundTurkishTranslation.setWord(userNotFoundTurkish);
            userNotFoundTurkishTranslation.setTranslation("Kullanıcı bulunamadı.");
            this.translationDao.save(userNotFoundTurkishTranslation);

            Translation cityAddedTurkishTranslation = new Translation();
            cityAddedTurkishTranslation.setLanguage(turkish);
            var cityAddedTurkish = this.wordDao.getWordsByKey("city.added");
            cityAddedTurkishTranslation.setWord(cityAddedTurkish);
            cityAddedTurkishTranslation.setTranslation("Şehir eklendi.");
            this.translationDao.save(cityAddedTurkishTranslation);

            Translation cityDeletedTurkishTranslation = new Translation();
            cityDeletedTurkishTranslation.setLanguage(turkish);
            var cityDeletedTurkish = this.wordDao.getWordsByKey("city.deleted");
            cityDeletedTurkishTranslation.setWord(cityDeletedTurkish);
            cityDeletedTurkishTranslation.setTranslation("Şehir silindi.");
            this.translationDao.save(cityDeletedTurkishTranslation);

            Translation cityUpdatedTurkishTranslation = new Translation();
            cityUpdatedTurkishTranslation.setLanguage(turkish);
            var cityUpdatedTurkish = this.wordDao.getWordsByKey("city.updated");
            cityUpdatedTurkishTranslation.setWord(cityUpdatedTurkish);
            cityUpdatedTurkishTranslation.setTranslation("Şehir güncellendi.");
            this.translationDao.save(cityUpdatedTurkishTranslation);

            Translation citiesListedTurkishTranslation = new Translation();
            citiesListedTurkishTranslation.setLanguage(turkish);
            var citiesListedTurkish = this.wordDao.getWordsByKey("cities.listed");
            citiesListedTurkishTranslation.setWord(citiesListedTurkish);
            citiesListedTurkishTranslation.setTranslation("Şehirler listelendi.");
            this.translationDao.save(citiesListedTurkishTranslation);


            Translation cityNotFoundTurkishTranslation = new Translation();
            cityNotFoundTurkishTranslation.setLanguage(turkish);
            var cityNotFoundTurkish = this.wordDao.getWordsByKey("city.not.found");
            cityNotFoundTurkishTranslation.setWord(cityNotFoundTurkish);
            cityNotFoundTurkishTranslation.setTranslation("Şehir bulunamadı.");
            this.translationDao.save(cityNotFoundTurkishTranslation);
        }
    }
}
